package com.hhho;

import java.util.Scanner;

public class Chihuo {
	public static void main(String[] args) {
		System.out.println("欢迎使用“吃货联盟订餐系统”");
		//主体数据
		String[] name =new String[4];//保存订单人姓名信息。
		String[] dishMegs=new String[4];//保存所选信息包括菜名及分数。
		int[] time =new int[4];//订餐时间
		String[] addresses= new String[4];//保存送餐人地址
		int[] states=new int[4];//保存订单状态：0表示已预定，1表示已完成。
		double[] sumprices= new double[4];//保存订单的金额。
		//供选择的菜品信息
		String[] dishNames={"红烧带鱼","鱼香肉丝","时令蔬菜"};
		double[] prices={38.0,20.0,10.0};//菜品单价
		int[] praiseNums=new int[3];//点赞数
		//初始化第一条订单信息
		name[0]="张庆";
		dishMegs[0]="红烧带鱼   2份";
		time[0]=13;
		addresses[0]="金水区白描小区";
		states[0]=0;
		sumprices[0]=76.0;
		//厨师化第二条订单信息
		name[1]="绯村";
		dishMegs[1]="鱼香肉丝  2份";
		time[1]=17;
		addresses[1]="文化路132号";
		states[1]=1;
		sumprices[1]=45.0;
		Scanner input=new Scanner(System.in);
		
		boolean isExit=false;
		int num=-1;
		do{
			//主体架构
			System.out.println("**********************************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("************************************");
			System.out.println("请选择相应的功能编号：");
			int choose=input.nextInt();
			boolean falg=false;  //当falg是真是找到了空位置，是假是输出订单已满
			switch(choose){
			case 1:
				System.out.println("****我要订餐****");
				for(int i=0;i<name.length;i++){
					//找到一个空位置
					if(name[i]==null){
						falg=true;
						
					
					System.out.println("序号\t"+"餐品名\t"+"单价\t"+"点赞数");
					
					for(int j=0;j<dishNames.length;j++){
						//遍历餐品信息
						
						System.out.println((j+1)+".\t"+dishNames[j]+"\t"+prices[j]+"元\t"+praiseNums[j]);
					}
					System.out.println("请选择所定餐品序号：");
					int numa=input.nextInt();
					System.out.println("请选择所定的份数：");
					int numb=input.nextInt();
					System.out.println("请输入订餐人的姓名：");
					String name1=input.next();
					System.out.println("请输入订餐时间（10-20整点送餐）");
					int time1=input.nextInt();
					while(time1<10|time1>20){
						System.out.println("您订餐时间输入有误，请重新输入");
						time1=input.nextInt();
					}
					System.out.println("请输入订餐地址：");
					String addes=input.next();
					System.out.println("订餐成功!");
					System.out.println("您定的是："+dishNames[numa-1]+" "+numb+"份");
					System.out.println("订餐人："+name1);
					System.out.println("送餐时间："+time1+"点");
					System.out.println("送餐地址是："+addes);
					double price=prices[numa-1]*numb;
					double price1=price<50? 6 : 0;
					System.out.println("餐费："+price+"元\t送餐费："+price1+"元");
					double sumprice=price+price1;
					System.out.println("总金额是："+sumprice+"元");
					//把数据存入数组
					name[i]=name1;
					dishMegs[i]=dishNames[numa-1]+" "+numb+"份";
					time[i]=time1;
					addresses[i]=addes;
					states[i]=0;
					sumprices[i]=sumprice;
						break;
					}
				}
			
				if(!falg){
					System.out.println("餐袋已满不能继续订餐");
				}
				
				break;
			case 2:
				System.out.println("****查看餐袋****");
				System.out.println("序号\t订餐人\t餐品信息\t\t送餐时间\t送餐地址\t\t总金额\t状态");
				for(int i=0;i<name.length;i++){
					String state=states[i]==0?"已预订":"已完成";
				   if(name[i]!=null){
					   System.out.println((i+1)+"\t"+name[i]+"\t"+dishMegs[i]+"\t"+time[i]+"\t"+addresses[i]+"\t"+sumprices[i]+"元\t"+state);
				   }
				}
				
				break;
			case 3:
				System.out.println("****签收订单****");
				System.out.println("请选择您要签收订单的序号：");
				int id=input.nextInt();
				boolean isfind=false; //判断是否找到订单信息，为true时找到，false时未找到
				for(int i=0;i<name.length;i++){//遍历数组
					//1.找到不为空的定单，是判断是否已完成
					if(name[i]!=null&&states[i]==1&&id-1==i){
						isfind=true;
						System.out.println("您的订单已完成，不能再次签收");
						break;
					}else if(name[i]!=null&&states[i]==0&&id-1==i){
						isfind=true;
						states[i]=1;
						System.out.println("签收成功！");
						break;
					}
				}
				//未找到订单序号时；
				if(!isfind){
					System.out.println("对不起，没有找到您要签收的定单");
				}
				break;
			case 4:
				System.out.println("****删除订单****");
				System.out.println("请选择您要删除订单的序号：");
				int dell=input.nextInt();
				int delindex=-1;
				boolean delfind=false;
				for(int i=0;i<name.length;i++){//遍历数组
					//找到数组不为空的位置.订单状态为已完成时，确定下标位置。
					if(name[i]!=null&&states[i]==1&&dell-1==i){
						delindex=i;
						delfind=true;
						System.out.println("已找到您要删除的订单");
						break;
					}else if(name[i]!=null&&states[i]==0&&dell-1==i){
						//订单状态是已预订，不能删除。
						delfind=true;
						System.out.println("您选择的订单未签收，不能删除");
						break;
					}
				}
				//未找到订单信息
				if(!delfind){
					System.out.println("未找到您要删除的订单");
				}
				if(delindex!=-1){//当delindex变量发生改变时，执行删除数组元素
					for(int i=delindex;i<name.length-1;i++){
						name[i]=name[i+1];
						dishMegs[i]=dishMegs[i+1];
						time[i]=time[i+1];
						addresses[i]=addresses[i+1];
						states[i]=states[i+1];
						sumprices[i]=sumprices[i+1];
					}
					//清空数组的最后一位
					name[name.length-1]=null;
					dishMegs[name.length-1]=null;
					time[name.length-1]=0;
					addresses[name.length-1]=null;
					states[name.length-1]=0;
					sumprices[name.length-1]=0;
					System.out.println("删除订单成功！");
				}
				break;
			case 5:
				System.out.println("****我要点赞****");
					
				System.out.println("序号\t"+"餐品名\t"+"单价\t"+"点赞数");
				
				for(int j=0;j<dishNames.length;j++){
					//遍历餐品信息
					
					System.out.println((j+1)+".\t"+dishNames[j]+"\t"+prices[j]+"元\t"+praiseNums[j]);
				}
				System.out.println("请输入要点赞的菜品序号：");
				int numc=input.nextInt();
				//点赞数加1
				praiseNums[numc-1]++;
				//显示点赞信息
				System.out.println("点赞成功！");
				System.out.println(dishNames[numc-1]+"\t"+prices[numc-1]+"元\t"+"点赞数："+praiseNums[numc-1]);
				break;
			case 6:
				isExit=true;
				break;
				default:
				isExit=true;
					break;
			}
		
			if(!isExit){	
				System.out.println("请输入0返回:");
				 num=input.nextInt();
			}else{
				break;
			}
			
				
		}while(num==0);
		System.out.println("谢谢使用，欢迎下次光临");
		
		
	}
}
