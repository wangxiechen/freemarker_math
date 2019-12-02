package com.wxc.math;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

/**
 * 数字签名DSA
 * @author YangJie [2017年10月10日 下午3:58:10]
 */
public class MathClass {

    /**
     * 签名
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */                                     //私钥
    public static String sign(String data, PrivateKey privateKey) throws Exception {
        //签名 signature是对某段数据的摘要进行加密的结果
        Signature signature = Signature.getInstance(KeyFactory.getInstance("DSA").getAlgorithm());
        //      初始化这个用于签名的对象
        signature.initSign(privateKey);
        signature.update(data.getBytes());
        //它将 Unicode 字符序列转换为已编码的字节序列 是import android.util.Base64; 只能使用encodeToString 方法
        return Base64.getEncoder().encodeToString(signature.sign());
    }

    /**
     * 验证
     * @param data
     * @param sign
     * @param publicKey
     * @return
     * @throws Exception
     */                                                    //公钥
    public static boolean verify(String data, String sign, PublicKey publicKey) throws Exception {
        //      它将已编码的字节序列转换为字符序列。
        byte[] bytes = Base64.getDecoder().decode(sign);
        //                                          getInstance();返回keyFactory对象,此方法有多个重载方法
        Signature signature = Signature.getInstance(KeyFactory.getInstance("DSA").getAlgorithm());
        //        验证，检验   公钥
        signature.initVerify(publicKey);
        signature.update(data.getBytes());
        return signature.verify(bytes);
    }

    /**
     * 生成密钥对
     * @return
     * @throws Exception
     */
    public static KeyPair genKeyPair() throws Exception {
        //KeyPairGenerator 类用于生成公钥和私钥对
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        //initialize运行在init之后  当一个类在查找方法的时候, 会先判断当前类是否初始化, 如果没有初始化就会去掉用initialize方法
        keyPairGenerator.initialize(1024);
        return keyPairGenerator.generateKeyPair();
    }


    public static void main(String[] args) throws Exception {
        //创建了一个字符串
        String data = "hello world";

        KeyPair keyPair = genKeyPair();

        // 获取公钥，并以base64格式打印出来 将string转换成PublicKey
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("公钥：" + Base64.getEncoder().encodeToString(publicKey.getEncoded()));

        // 获取私钥，并以base64格式打印出来
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("私钥：" + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        // 签名
        String sign = sign(data, privateKey);
        System.out.println("签名：" + sign);

        // 验证
        boolean flag = verify(data, sign, publicKey);
        System.out.println("验证：" + flag);

    }


}