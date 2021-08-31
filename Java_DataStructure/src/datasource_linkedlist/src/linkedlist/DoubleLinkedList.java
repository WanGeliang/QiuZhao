package datasource_linkedlist.src.linkedlist;

/**
 * @author 万葛亮
 * @Date 2020 06 29 22:41
 * @GIRL friend 江珊
 */
public class DoubleLinkedList {
    public static void main(String[] args) {

        System.out.println("双向链表的测试~~~");
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DouleLinkedListdemo listdemo = new DouleLinkedListdemo();
//        listdemo.addByOrder(hero1);
//        listdemo.addByOrder(hero3);
//        listdemo.addByOrder(hero2);
//        listdemo.addByOrder(hero4);

        listdemo.add(hero1);
        listdemo.add(hero3);
        listdemo.add(hero2);
        listdemo.add(hero4);
        //显示
        listdemo.list();
        //修改
        HeroNode2 hero5 = new HeroNode2(4, "6666", "james");

        listdemo.update(hero5);
        System.out.println("修改后的节点~~~");
        listdemo.list();

        //删除
        listdemo.delete(3);
        System.out.println("删除后的节点~~~");
        listdemo.list();
    }
}

class DouleLinkedListdemo {
    //初始化一个头节点
    HeroNode2 head = new HeroNode2(0, "", "");

    /*
     * 返回头节点
     * */
    public HeroNode2 getHead() {
        return head;
    }
    /**
     * 添加有序链表
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode2 heroNode) {
        //首先定义一个辅助节点
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断是否添加新的节点
        if (flag) {
            System.out.printf("已经存在节点%d，不能再添加了\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
//            temp.next.pre=heroNode.next.pre;
            
        }
    }

    /**
     * 删除节点号删除节点
     */
    public void delete(int no) {

        //先判断是否为空
        if (head.next == null) {
            System.out.println("链表为空，不能删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.no == no) {
                //找到了节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {

            //如果删除的使最后一个节点
            if (temp !=null && temp.next != null) {
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
            }else {
                temp=null;
            }
        } else {
            System.out.printf("链表中不存在%d节点\n", no);
        }
    }

    /**
     * 根据添加节点的序号来修改链表
     *
     * @param heroNode
     */
    public void update(HeroNode2 heroNode) {
        //还是得有一个辅助节点
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断是否添加新的节点
        if (flag) {
            temp.next.nickname = heroNode.nickname;
            temp.next.name = heroNode.name;
        } else {
            System.out.printf("不存在节点%d，不能修改\n", heroNode.no);
        }
    }

    /**
     * 添加到双向链表的最后
     *
     * @param heroNode
     */
    public void add(HeroNode2 heroNode) {
        //因为头节点不能动，所以需要一个辅助节点
        HeroNode2 temp = head;

        //遍历
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向新的节点
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    //显示链表[遍历]

    /**
     * 显示链表
     */
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }
}

//定义HeroNode ， 每个HeroNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; //指向下一个节点
    public HeroNode2 pre;//指向前一个节点

    //构造器
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}
