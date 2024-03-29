package com.jagt.employ.user.hello.domain.entity;

import com.jagt.employ.common.entity.BaseEntity;
import com.jagt.employ.user.hello.domain.vo.HelloV;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity 实体对象
 *
 * 有唯一标识，可变的业务实体对象，它有着自己的生命周期。
 * 【重点】一定要采用不依赖repository的充血模型
 * 设计时要考虑聚合，不需要每个实体都有对应的仓库
 *
 * @author gotanks
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "HELLO")
//继承BaseEntity，包含主键和乐观锁，也可继承BaseTimeEntity，BaseTreeEntity
public class HelloE extends BaseEntity{
    /**
     * 字段
     */
    @Column
    private String name;

    @Column
    private String msg;

    @Embedded
    private HelloV helloV;

    /**
     * 生成msg
     * @return
     */
    public void buildMsg(String prop) {
        StringBuilder result = new StringBuilder();
        result.append("hello ")
                .append(this.name)
                .append("!! 由于读取缓存，相同name时间戳不变。");
        if(prop!=null){
            result.append("配置属性：").append(prop);
        }
        this.setMsg(result.toString());
    }

    /**
     * 更新时间戳
     */
    public void updateTime(){
        if(this.getHelloV() == null){
            this.setHelloV(new HelloV());
        }
        this.getHelloV().setField(System.currentTimeMillis()+"");
    }
}
