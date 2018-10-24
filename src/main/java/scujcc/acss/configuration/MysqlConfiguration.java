package scujcc.acss.configuration;/**
 * @author CZM
 * @create 2018-10-24 上午 09:45
 */

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 *@ClassNmae MysqlConfiguration
 *@Description TODO
 *@Author CZM
 *@Date 2018/10/24 上午 09:45
 *@Version 1.0
 **/
public class MysqlConfiguration extends MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString(){
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
