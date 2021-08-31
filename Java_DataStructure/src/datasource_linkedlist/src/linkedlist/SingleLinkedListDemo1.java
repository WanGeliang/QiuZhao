package datasource_linkedlist.src.linkedlist;

import java.util.Stack;

/**
 * @author 万葛亮
 * @Date 2020 06 11 15:30
 * @GIRL friend 江珊
 */
public class SingleLinkedListDemo1 {
    public static void main(String[] args) {
//进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        HeroNode m1 = new HeroNode(1, "kkk", "及kkk");
        HeroNode m2 = new HeroNode(2, "lll", "玉lll");
        HeroNode m3 = new HeroNode(3, "www", "智www");
        HeroNode m4 = new HeroNode(4, "林ccc", "豹ccc");


        //创建要给链表
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();

        SingleLinkedList singleLinkedList2 = new SingleLinkedList();


        //无序链表加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);

        //有序
        singleLinkedList1.addByOrder(hero1);
        singleLinkedList1.addByOrder(hero4);
        singleLinkedList1.addByOrder(hero2);
        singleLinkedList1.addByOrder(hero3);

        singleLinkedList2.addByOrder(m2);
        singleLinkedList2.addByOrder(m1);
        singleLinkedList2.addByOrder(m4);
        singleLinkedList2.addByOrder(m3);

      // 测试一下单链表的反转功能
//        System.out.println("原来链表的情况~~");
//        singleLinkedList1.list();
/*
        HeroNode hero5 = new HeroNode(5, "林冲6666", "6666豹子头");
        singleLinkedList.update(hero5);
        System.out.println("更新链表的情况~~");
        singleLinkedList.list();

        //删除节点
        singleLinkedList.delete(1);
        System.out.println("更新链表的情况~~");
        singleLinkedList.list();

        //获取有效节点的个数
        int lenth = getLenth(singleLinkedList.head);
        System.out.printf("有效节点的个数为%d\n",lenth);

        //获取倒数第k个节点
        getK_heronode(singleLinkedList.head,3);
*/
        //将单链表反转
//        System.out.println("反转链表的情况~~");
//        reversetList(singleLinkedList.head);
//        singleLinkedList.list();

        //百度面试：反转打印
//        System.out.println("反转链表的情况~~没有改变链表的数据结构");
//        printReverse(singleLinkedList1.head);

        //合并两个有序链表仍然有序
        System.out.println("原来链表的情况~~");

        singleLinkedList1.list();
        System.out.println("**************************");
        singleLinkedList2.list();
        TwoLinkedToOne(singleLinkedList1.head, singleLinkedList2.head);
        System.out.println("合并两个有序链表仍然有序~~~~");
//        System.out.println(heroNode.toString());
//        singleLinkedList2.list();

        singleLinkedList1.list();
    }



    //(自己练习)将两个有序链表合并成一个，结果仍然是有序的
    public static void TwoLinkedToOne(HeroNode h1,HeroNode h2){
        HeroNode node = new HeroNode(0, "", "");

//      先将第一个有序链表进行反转
        HeroNode next =null;
        HeroNode cur =h2.next;
        while (cur!=null){
            next=cur.next;
            cur.next=node.next;
            node.next=cur;
            cur=next;
        }

        h2.next=node.next;
//      再将反转的链表按照遍历的顺序进行依次排列插入
        HeroNode cr =h2.next;
        while (cr!=null){
            next=cr.next;
            cr.next=h1.next;
            h1.next=cr;
            cr=next;
        }
    }


    //将链表从尾到头打印（百度面试）
    public static void printReverse(HeroNode hero){
        if (hero.next==null){
            return;
        }
        Stack<HeroNode> nodeStack = new Stack<>();
        HeroNode cur=hero.next;
        while (cur!=null){
            nodeStack.push(cur);
            cur=cur.next;
        }

        while (nodeStack.size()>0){
            System.out.println(nodeStack.pop());
        }
    }
    //腾讯面试题（将单链表反转）
    //将单链表反转
    public static void reversetList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if(head.next == null || head.next.next == null) {
            return ;
        }

        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;// 指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        //动脑筋
        while(cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur 连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }

    //查找单链表的倒数第k个节点
    public static void getK_heronode(HeroNode head,int k){
        int i = getLenth(head);//3
        int j=i-k+1;
        HeroNode temp=head;
        while (true){
            if (j==0){
                System.out.println(temp);
                break;
            }
            temp=temp.next;
            j--;
        }
//        return null;
    }
    /**
     * 获取单链表节点的有效个数
     * @param head
     * @return
     */
    public static int getLenth(HeroNode head){
        int length=0;
        if(head.next==null){
            return 0;
        }
        HeroNode cur=head.next;
        while (cur!=null){
            length++;
            cur=cur.next;
        }
        return length;

    }
}

//定义一个链表
class SingleLinkedList {
    //初始化一个头节点
    HeroNode head = new HeroNode(0, "", "");


    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点

    /**
     * 添加无序链表
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        //因为头节点不能动，所以需要一个辅助节点
        HeroNode temp = head;

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
    }


    /**
     * 添加有序链表
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        //首先定义一个辅助节点
        HeroNode temp = head;
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
        }
    }

    /**
     * 删除节点
     */
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                //找到了节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        }else {
            System.out.printf("链表中不存在%d节点\n",no);
        }
    }


    /**
     * 根据添加节点的序号来修改链表
     * @param heroNode
     */
    public void update(HeroNode heroNode) {
        //还是得有一个辅助节点
        HeroNode temp = head.next;
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
        HeroNode temp = head.next;
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
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
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
