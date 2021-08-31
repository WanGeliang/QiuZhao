package datasource_huffmancode.src.com;


import java.io.*;
import java.util.*;

/**
 * @author 万葛亮
 * @Date 2020 07 30 0:18
 * @GIRL friend 江珊
 */
public class HuffmanCode {
    public static void main(String[] args) {
       /* String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();

        byte[] zipHuffmanCodes = zipHuffmanCodes(bytes);
        System.out.println("zipHuffmanCodes编码为:" + Arrays.toString(zipHuffmanCodes) + "长度为：" + zipHuffmanCodes.length);
//        System.out.println("解码前的huffman编码：" + Arrays.toString(zip(bytes, huffmancodes)));
        byte[] sourceString = decode(huffmancodes, zipHuffmanCodes);
        System.out.println(new String(sourceString));
        */
//        String srcFile = "C:\\Users\\WGL\\Desktop\\test\\1.png";
//        String dstFile = "C:\\Users\\WGL\\Desktop\\test\\2.zip";
//        zipFile(srcFile,dstFile);
//        System.out.println("压缩图片成功");

        String zipFile = "C:\\Users\\WGL\\Desktop\\test\\2.zip";
        String decodeFile = "C:\\Users\\WGL\\Desktop\\test\\2.png";
        unZipFile(zipFile, decodeFile);
        System.out.println("解压图片成功");
//        System.out.println( getNodeMessage(str));
        //测试创建的二叉树
//        Node root = createHuffmanTree(getNodeMessage(str));
//        preOrderHuffman(root);
        //测试创建的哈夫曼编码
//        getHuffmanCodes(root, "", stringBuilder);
//        getHuffmancodes(root);
//        System.out.println(huffmancodes);
//
//        byte[] zip = zip(bytes, huffmancodes);
//        System.out.println("huffmancodes转成十进制的数组"+Arrays.toString(zip));
    }

    //编写一个方法，完成对压缩文件的解压

    /**
     * @param zipFile 准备解压的文件
     * @param dstFile 将文件解压到哪个路径
     */
    public static void unZipFile(String zipFile, String dstFile) {
        FileInputStream is = null;
        FileOutputStream os = null;
        ObjectInputStream ois = null;
        try {
            is = new FileInputStream(zipFile);
            os = new FileOutputStream(dstFile);
            ois = new ObjectInputStream(is);
            byte[] huffmanbytes = (byte[]) ois.readObject();
            Map<Byte, String> hufmancodes = (Map<Byte, String>) ois.readObject();
            byte[] decodeBytes = decode(hufmancodes, huffmanbytes);
            os.write(decodeBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //
    //编写方法，将一个文件进行压缩

    /**
     * @param srcFile 你传入的希望压缩的文件的全路径
     * @param dstFile 我们压缩后将压缩文件放到哪个目录
     */
    public static void zipFile(String srcFile, String dstFile) {
        FileInputStream is = null;
        FileOutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            is = new FileInputStream(srcFile);
            int available = is.available();
            byte[] b = new byte[available];
            is.read(b);
            os = new FileOutputStream(dstFile);
            oos = new ObjectOutputStream(os);
            byte[] huffmanbytes = zipHuffmanCodes(b);
            oos.writeObject(huffmanbytes);
            oos.writeObject(huffmancodes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
//完成数据的解压
    //思路
    //1. 将huffmanCodeBytes [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
    //   重写先转成 赫夫曼编码对应的二进制的字符串 "1010100010111..."
    //2.  赫夫曼编码对应的二进制的字符串 "1010100010111..." =》 对照 赫夫曼编码  =》 "i like like like java do you like a java"


    //编写一个方法，完成对压缩数据的解码

    /**
     * @param huffmanCodes 赫夫曼编码表 map
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 就是原来的字符串对应的数组
     */
    public static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {

        //1. 先得到 huffmanBytes 对应的 二进制的字符串 ， 形式 1010100010111...
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        System.out.println("解码后的huffman编码:" + stringBuilder.toString());
        HashMap<String, Byte> map = new HashMap<>();//将Huffman编码反转存储000=108, 01=32,
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()
        ) {
            map.put(entry.getValue(), entry.getKey());
        }
//        System.out.println(map);
        ArrayList<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                String  key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
        return bytes;

    }

    /**
     * 将一个byte 转成一个二进制的字符串, 如果看不懂，可以参考我讲的Java基础 二进制的原码，反码，补码
     *
     * @param b    传入的 byte
     * @param flag 标志是否需要补高位如果是true ，表示需要补高位，如果是false表示不补, 如果是最后一个字节，无需补高位
     * @return 是该b 对应的二进制的字符串，（注意是按补码返回）
     */
    public static String byteToBitString(boolean flag, byte b) {
        int temp = b;//将byte转成int，因为int中才有str转成10进制的方法
        if (flag) {
            temp |= 256;
        }
        String s = Integer.toBinaryString(temp);
        if (flag) {
            return s.substring(s.length() - 8);//取出高位
        } else {
            return s;
        }
    }

    /**
     * 将编码的方法进行封装，最后直接调用
     *
     * @param bytes 传入的数组
     * @return
     */
    public static byte[] zipHuffmanCodes(byte[] bytes) {
        //1、将传入的字节数组生成对应的node节点
        List<Node> nodeList = getNodeMessage(bytes);
        //2、将node节点生成huffman树
        Node huffmanTree = createHuffmanTree(nodeList);
        //3、将对应的Huffman树生成对应的huffman编码
        Map<Byte, String> huffmancodes = getHuffmancodes(huffmanTree);
        //4、将huffman编码压缩成对应的10进制编码数组
        byte[] zip = zip(bytes, huffmancodes);
        return zip;
    }

    /**
     * 将霍夫曼编码转成一个数组
     *
     * @param bytes
     * @return 将二进制的霍夫曼编码表转为十进制的字节数组
     */
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : bytes) {
            stringBuilder.append(huffmanCodes.get(by));
        }
        System.out.println("解码前的huffman编码:" + stringBuilder.toString());
        int len;
        //获取构造霍夫曼编码数组的长度
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        byte[] bytes1 = new byte[len];
        String strByte;
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
//               bytes1[index++]=(byte) Integer.parseInt(stringBuilder.substring(i),2);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
//                bytes1[index++]=(byte) Integer.parseInt(stringBuilder.substring(i,i+8),2);
            }
            bytes1[index++] = (byte) Integer.parseInt(strByte, 2);
        }
        return bytes1;
    }

    static Map<Byte, String> huffmancodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    //为了方便调用huffman编码表0110101....
    public static Map<Byte, String> getHuffmancodes(Node root) {
        if (root == null) {
            return null;
        }
        getHuffmanCodes(root.left, "0", stringBuilder);
        getHuffmanCodes(root.right, "1", stringBuilder);
        return huffmancodes;
    }

    /**
     * @param node 传入的根节点
     * @param code left为0，right为1
     * @param sb   得到二进制的huffman编码
     */
    public static void getHuffmanCodes(Node node, String code, StringBuilder sb) {
        StringBuilder stringBuilder1 = new StringBuilder(sb);
        stringBuilder1.append(code);
        if (node != null) {
            if (node.data == null) {
                getHuffmanCodes(node.left, "0", stringBuilder1);
                getHuffmanCodes(node.right, "1", stringBuilder1);
            } else {
                huffmancodes.put(node.data, stringBuilder1.toString());
            }
        }

    }

    /**
     * @param bytes 传入字符窜
     * @return 返回list集合，是排序过后的node，里面的内容是字符对应出现的次数
     */
    public static List<Node> getNodeMessage(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<>();
        HashMap<Byte, Integer> map = new HashMap<>();
//        byte[] bytes = str.getBytes();
        for (Byte bt : bytes) {
            Integer count = map.get(bt);
            if (count == null) {
                map.put(bt, 1);
            } else {
                map.put(bt, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> mapp : map.entrySet()) {
            nodes.add(new Node(mapp.getKey(), mapp.getValue()));
        }
        return nodes;
    }

    /**
     * 创建霍夫曼树
     *
     * @param list
     * @return
     */
    public static Node createHuffmanTree(List<Node> list) {
        while (list.size() > 1) {
            Collections.sort(list);
            Node leftNode = list.get(0);
            Node rightNode = list.get(1);
            Node parentNode = new Node(null, leftNode.weight + rightNode.weight);
            parentNode.left = leftNode;
            parentNode.right = rightNode;
            list.remove(leftNode);
            list.remove(rightNode);
            list.add(parentNode);
        }
        return list.get(0);
    }

    /**
     * 前序遍历霍夫曼树
     *
     * @param root
     */
    public static void preOrderHuffman(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("无法创建霍夫曼树~~~");
        }

    }
}


class Node implements Comparable<Node> {
    public Byte data;
    public Integer weight;
    public Node left;
    public Node right;

    public Node(Byte data, Integer weight) {
        this.data = data;
        this.weight = weight;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
