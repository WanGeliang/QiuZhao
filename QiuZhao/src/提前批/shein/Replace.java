package 提前批.shein;

/**
 * @author Geliang
 * @date 2021-07-14
 * @slogan 致敬大师，致敬未来的你！
 */
public class Replace {

    public static void main(String[] args) {
        char chas[]= new char[]{'a',' ',' ','b',' ',' ','c'};
        System.out.println(Replace.replace(chas));
//        for (char res:replace){
//            System.err.print(res);
//        }
    }
    public static String replace(char chas[]){
        if (chas == null || chas.length==0){
            return null;
        }
        //空格数量
        int num = 0;
        //chas左半区长度
        int len = 0;
        for (len = 0;len<chas.length && chas[len]!=0;len++){
            if(chas[len]==' '){
                num++;
            }
        }
        int j = len+2*num-1;
        char result[] = new char[j+1];
        for(int i=len-1;i>-1;i--){
            if(chas[i]!=' '){
                result[j--]=chas[i];
            }else {
                result[j--]='0';
                result[j--]='2';
                result[j--]='%';
            }
        }
        return new String(result);
    }


}
