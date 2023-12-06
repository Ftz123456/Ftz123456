package com.example.springscuritybasic.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ftz
 * 创建时间:6/12/2023 上午11:25
 * 描述: TODO
 */
@Data
public class Authority implements Serializable {
    Long id;
    String authority;
}
