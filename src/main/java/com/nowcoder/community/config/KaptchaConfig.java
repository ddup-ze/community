package com.nowcoder.community.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KaptchaConfig {

    @Bean
    public Producer kaptchaProducer() {
        Properties properties = new Properties();
        properties.setProperty("kaptcha.image.width", "100");//宽
        properties.setProperty("kaptcha.image.height", "40");//高
        properties.setProperty("kaptcha.textproducer.font.size", "32");//字号
        properties.setProperty("kaptcha.textproducer.font.color", "0,0,0");//字体颜色，黑色000
        properties.setProperty("kaptcha.textproducer.char.string", "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYAZ");//随机字符范围
        properties.setProperty("kaptcha.textproducer.char.length", "4");//随机字符长度
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");//干扰，噪声

        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Config config = new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;
    }

}
