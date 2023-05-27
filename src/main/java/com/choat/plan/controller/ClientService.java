package com.choat.plan.controller;

import com.choat.plan.controller.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class ClientService {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "choat/plan/getUserById",method = RequestMethod.GET)
    public UserVO getUser(@RequestParam(value = "userId") Long userId){
        UserVO userVo = new UserVO();
        userVo.setUserId(userId);
        log.debug("开始");
        userVo.setUserName((String) redisTemplate.opsForValue().get(userId.toString()));
        log.debug("执行到这里了");
        return userVo;
    }

    @RequestMapping(value = "choat/plan/saveUser",method = RequestMethod.POST)
    public void saveUser(@RequestBody UserVO userVO){
        redisTemplate.opsForValue().set(userVO.getUserId().toString(),
                userVO.getUserName(),
                30,
                TimeUnit.SECONDS);
    }

}
