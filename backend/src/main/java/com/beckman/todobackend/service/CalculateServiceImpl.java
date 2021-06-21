package com.beckman.todobackend.service;

import com.beckman.todobackend.config.RedisUtil;
import com.beckman.todobackend.model.CalculateResult;
import com.beckman.todobackend.repository.CalculateResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CalculateServiceImpl implements CalculateService {

    private final CalculateResultRepository calculateResultRepository;

    private final RedisUtil redisUtil;

    @Override
    public Long getCalculateResult(long number) {
        if (redisUtil.hasKey(Long.toString(number))) {
            String val = (String) redisUtil.get(Long.toString(number));
            return Long.parseLong(val, 10);
        }

        redisUtil.set(Long.toString(number), Long.toString(number * number));

        CalculateResult result = calculateResultRepository.findCalculateResultByNumber(number);

        if (result == null) {
            long tempResult = number * number;
            CalculateResult newResult = new CalculateResult();
            newResult.setNumber(number);
            newResult.setResult(tempResult);
            calculateResultRepository.save(newResult);

            return number * number;
        }

        return result.getResult();
    }
}
