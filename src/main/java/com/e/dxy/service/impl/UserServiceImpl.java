package com.e.dxy.service.impl;

import com.e.dxy.dao.UserRepository;
import com.e.dxy.domain.UserDomain;
import com.e.dxy.event.message.UserMessage;
import com.e.dxy.service.UserService;
import com.e.dxy.utils.Response;
import com.e.dxy.vo.UserVO;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@SuppressWarnings("unchecked")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Value("${user.age}")
    private Integer age;

    @Value("${user.time}")
    private Integer time;

    @Override
    public UserDomain getIfPresent(Integer id){
        return userRepository.findById(id).orElse(new UserDomain());
    }

    // 用户新增
    public Response<UserVO> add(UserVO userData) {

        UserDomain user = new UserDomain();
        user.setUsername(userData.getUsername());
        user.setPassword(userData.getPassword());

        userRepository.save(user);
        return Response.success(user);
    }

    // 用户更新
    public Response<UserVO> update(UserVO userData) {
        UserDomain user = this.getIfPresent(userData.getId());
        if (null == user) {
            return Response.error("400", "用户不存在");
        }

        user.setUsername(userData.getUsername());
        user.setPassword(userData.getPassword());

        userRepository.save(user);
        return Response.success(user);
    }

    // 用户删除
    public Response<UserVO> delete(Integer id) {

        UserDomain user = this.getIfPresent(id);

        if (null == user) {
            return Response.error("400", "用户不存在");
        }

        userRepository.deleteById(id);

        return Response.success();
    }


    // 根据名字模糊查询用户列表
    public Response<UserVO> searchByUsername(Integer page, Integer size, String username) {

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page - 1, size, sort);

        Page<UserDomain> userVOS = userRepository.searchByUsername(pageable, username);

        List<UserVO> res = userVOS.stream().map(o -> UserVO.builder()
                .id(o.getId())
                .password(o.getPassword())
                .username(o.getUsername())
                .createTime(o.getCreateTime())
                .build())
                .collect(Collectors.toList());

        return Response.success(res);
    }


    // 用户详情
    public Response<UserVO> detail(Integer id){

        UserDomain userVOS = this.getIfPresent(id);
        if (null == userVOS) {
            return Response.error("400", "用户不存在");
        }

        UserVO res = UserVO.builder()
                .id(userVOS.getId() + age + time)
                .password(userVOS.getPassword())
                .username(userVOS.getUsername())
                .createTime(userVOS.getCreateTime())
                .build();
        // 发送消
        UserMessage userMessage = UserMessage.builder().id(userVOS.getId()).build();

        rocketMQTemplate.syncSend(UserMessage.TOPIC, userMessage);
        return Response.success(res);
    }

    // 用户列表
    public Response<UserVO> list() {
        List<UserDomain> userVOS = userRepository.findAll();

        List<UserVO> res = userVOS.stream().map(o -> UserVO.builder()
                .id(o.getId())
                .password(o.getPassword())
                .createTime(o.getCreateTime())
                .username(o.getUsername())
                .build())
                .collect(Collectors.toList());

        // 消费消息

        return Response.success(res);
    }
}
