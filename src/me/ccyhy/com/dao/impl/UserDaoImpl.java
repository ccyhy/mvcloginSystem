package me.ccyhy.com.dao.impl;

import me.ccyhy.com.dao.IUserDao;
import me.ccyhy.com.domain.User;
import me.ccyhy.com.util.WebUtils;
import me.ccyhy.com.util.XmlUtils;
import org.dom4j.Document;
import org.dom4j.Element;

import javax.management.relation.RoleUnresolved;
import java.text.SimpleDateFormat;

public class UserDaoImpl implements IUserDao
{
    @Override
    public User find(String userName, String userPwd) {
       //获取数据文件关联文档对象
        try
        {
            Document document= XmlUtils.getDocument();
            //使用XPath来操作xml的节点，这里根据用户名和密码，取出一个Element元素
            Element e=(Element)document.selectSingleNode("//user[@userName='"+userName+"'and @userPwd='"+userPwd+"']");
            //判断
            if(e==null)
            {
                return null;
            }
            //如果e不为null，则代表取到了e元素对象，那么其中的各个节点都有了数据，此刻新建一个user对象，将e中封装的数据赋值给user的各个属性
            User user=new User();
            user.setId(e.attributeValue("id"));
            user.setUserName(e.attributeValue("userName"));
            user.setUserPwd(e.attributeValue("userPwd"));
            user.setEmail(e.attributeValue("email"));
            String birth=e.attributeValue("birthday");
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birth));
            return user;
        }
        catch (Exception e)
        {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void add(User user)
    {
        //添加用户思路
        /**
         * 1，获取Document对象，新创建一个根节点作为新user的根节点
         * 2，取出参数user的属性值，然后利用根节点对象，创建子节点，将参数user属性值一一对象设置给子节点
         * 3, 将document对象利用XmlUtil工具写入xml文件
         */
        try
        {
            Document document=XmlUtils.getDocument();
            //新建根节点
            Element root=document.getRootElement();
            //创建user节点，并且挂到根节点之下
            Element user_node=root.addElement("user");
            //取出user中存储的属性值赋值给user_node的各个属性
            user_node.addAttribute("id",user.getId());
            user_node.addAttribute("userName",user.getUserName());
            user_node.addAttribute("userPwd",user.getUserPwd());
            user_node.addAttribute("email",user.getEmail());
            user_node.addAttribute("birthday",new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday()));
            //将修改后的document对象写入xml
            XmlUtils.write2Xml(document);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public User find(String userName)
    {
        //与上一个找user的方法一样，注意xpath的语句即可
//获取数据文件关联文档对象
        try
        {
            Document document= XmlUtils.getDocument();
            //使用XPath来操作xml的节点，这里根据用户名和密码，取出一个Element元素
//            Element e=(Element)document.selectSingleNode("//user[@userName='"+userName+"'and @userPwd='"+userPwd+"']");
            Element e=(Element)document.selectSingleNode("//user[@userName='"+userName+"']");
            //判断
            if(e==null)
            {
                return null;
            }
            //如果e不为null，则代表取到了e元素对象，那么其中的各个节点都有了数据，此刻新建一个user对象，将e中封装的数据赋值给user的各个属性
            User user=new User();
            user.setId(e.attributeValue("id"));
            user.setUserName(e.attributeValue("userName"));
            user.setUserPwd(e.attributeValue("userPwd"));
            user.setEmail(e.attributeValue("email"));
            String birth=e.attributeValue("birthday");
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birth));
            return user;
        }
        catch (Exception e)
        {
            throw  new RuntimeException(e);
        }
    }
}
