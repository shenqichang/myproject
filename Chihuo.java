package com.hhho;

import java.util.Scanner;

public class Chihuo {
	public static void main(String[] args) {
		System.out.println("��ӭʹ�á��Ի����˶���ϵͳ��");
		//��������
		String[] name =new String[4];//���涩����������Ϣ��
		String[] dishMegs=new String[4];//������ѡ��Ϣ����������������
		int[] time =new int[4];//����ʱ��
		String[] addresses= new String[4];//�����Ͳ��˵�ַ
		int[] states=new int[4];//���涩��״̬��0��ʾ��Ԥ����1��ʾ����ɡ�
		double[] sumprices= new double[4];//���涩���Ľ�
		//��ѡ��Ĳ�Ʒ��Ϣ
		String[] dishNames={"���մ���","������˿","ʱ���߲�"};
		double[] prices={38.0,20.0,10.0};//��Ʒ����
		int[] praiseNums=new int[3];//������
		//��ʼ����һ��������Ϣ
		name[0]="����";
		dishMegs[0]="���մ���   2��";
		time[0]=13;
		addresses[0]="��ˮ������С��";
		states[0]=0;
		sumprices[0]=76.0;
		//��ʦ���ڶ���������Ϣ
		name[1]="糴�";
		dishMegs[1]="������˿  2��";
		time[1]=17;
		addresses[1]="�Ļ�·132��";
		states[1]=1;
		sumprices[1]=45.0;
		Scanner input=new Scanner(System.in);
		
		boolean isExit=false;
		int num=-1;
		do{
			//����ܹ�
			System.out.println("**********************************");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("************************************");
			System.out.println("��ѡ����Ӧ�Ĺ��ܱ�ţ�");
			int choose=input.nextInt();
			boolean falg=false;  //��falg�������ҵ��˿�λ�ã��Ǽ��������������
			switch(choose){
			case 1:
				System.out.println("****��Ҫ����****");
				for(int i=0;i<name.length;i++){
					//�ҵ�һ����λ��
					if(name[i]==null){
						falg=true;
						
					
					System.out.println("���\t"+"��Ʒ��\t"+"����\t"+"������");
					
					for(int j=0;j<dishNames.length;j++){
						//������Ʒ��Ϣ
						
						System.out.println((j+1)+".\t"+dishNames[j]+"\t"+prices[j]+"Ԫ\t"+praiseNums[j]);
					}
					System.out.println("��ѡ��������Ʒ��ţ�");
					int numa=input.nextInt();
					System.out.println("��ѡ�������ķ�����");
					int numb=input.nextInt();
					System.out.println("�����붩���˵�������");
					String name1=input.next();
					System.out.println("�����붩��ʱ�䣨10-20�����Ͳͣ�");
					int time1=input.nextInt();
					while(time1<10|time1>20){
						System.out.println("������ʱ��������������������");
						time1=input.nextInt();
					}
					System.out.println("�����붩�͵�ַ��");
					String addes=input.next();
					System.out.println("���ͳɹ�!");
					System.out.println("�������ǣ�"+dishNames[numa-1]+" "+numb+"��");
					System.out.println("�����ˣ�"+name1);
					System.out.println("�Ͳ�ʱ�䣺"+time1+"��");
					System.out.println("�Ͳ͵�ַ�ǣ�"+addes);
					double price=prices[numa-1]*numb;
					double price1=price<50? 6 : 0;
					System.out.println("�ͷѣ�"+price+"Ԫ\t�Ͳͷѣ�"+price1+"Ԫ");
					double sumprice=price+price1;
					System.out.println("�ܽ���ǣ�"+sumprice+"Ԫ");
					//�����ݴ�������
					name[i]=name1;
					dishMegs[i]=dishNames[numa-1]+" "+numb+"��";
					time[i]=time1;
					addresses[i]=addes;
					states[i]=0;
					sumprices[i]=sumprice;
						break;
					}
				}
			
				if(!falg){
					System.out.println("�ʹ��������ܼ�������");
				}
				
				break;
			case 2:
				System.out.println("****�鿴�ʹ�****");
				System.out.println("���\t������\t��Ʒ��Ϣ\t\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t״̬");
				for(int i=0;i<name.length;i++){
					String state=states[i]==0?"��Ԥ��":"�����";
				   if(name[i]!=null){
					   System.out.println((i+1)+"\t"+name[i]+"\t"+dishMegs[i]+"\t"+time[i]+"\t"+addresses[i]+"\t"+sumprices[i]+"Ԫ\t"+state);
				   }
				}
				
				break;
			case 3:
				System.out.println("****ǩ�ն���****");
				System.out.println("��ѡ����Ҫǩ�ն�������ţ�");
				int id=input.nextInt();
				boolean isfind=false; //�ж��Ƿ��ҵ�������Ϣ��Ϊtrueʱ�ҵ���falseʱδ�ҵ�
				for(int i=0;i<name.length;i++){//��������
					//1.�ҵ���Ϊ�յĶ��������ж��Ƿ������
					if(name[i]!=null&&states[i]==1&&id-1==i){
						isfind=true;
						System.out.println("���Ķ�������ɣ������ٴ�ǩ��");
						break;
					}else if(name[i]!=null&&states[i]==0&&id-1==i){
						isfind=true;
						states[i]=1;
						System.out.println("ǩ�ճɹ���");
						break;
					}
				}
				//δ�ҵ��������ʱ��
				if(!isfind){
					System.out.println("�Բ���û���ҵ���Ҫǩ�յĶ���");
				}
				break;
			case 4:
				System.out.println("****ɾ������****");
				System.out.println("��ѡ����Ҫɾ����������ţ�");
				int dell=input.nextInt();
				int delindex=-1;
				boolean delfind=false;
				for(int i=0;i<name.length;i++){//��������
					//�ҵ����鲻Ϊ�յ�λ��.����״̬Ϊ�����ʱ��ȷ���±�λ�á�
					if(name[i]!=null&&states[i]==1&&dell-1==i){
						delindex=i;
						delfind=true;
						System.out.println("���ҵ���Ҫɾ���Ķ���");
						break;
					}else if(name[i]!=null&&states[i]==0&&dell-1==i){
						//����״̬����Ԥ��������ɾ����
						delfind=true;
						System.out.println("��ѡ��Ķ���δǩ�գ�����ɾ��");
						break;
					}
				}
				//δ�ҵ�������Ϣ
				if(!delfind){
					System.out.println("δ�ҵ���Ҫɾ���Ķ���");
				}
				if(delindex!=-1){//��delindex���������ı�ʱ��ִ��ɾ������Ԫ��
					for(int i=delindex;i<name.length-1;i++){
						name[i]=name[i+1];
						dishMegs[i]=dishMegs[i+1];
						time[i]=time[i+1];
						addresses[i]=addresses[i+1];
						states[i]=states[i+1];
						sumprices[i]=sumprices[i+1];
					}
					//�����������һλ
					name[name.length-1]=null;
					dishMegs[name.length-1]=null;
					time[name.length-1]=0;
					addresses[name.length-1]=null;
					states[name.length-1]=0;
					sumprices[name.length-1]=0;
					System.out.println("ɾ�������ɹ���");
				}
				break;
			case 5:
				System.out.println("****��Ҫ����****");
					
				System.out.println("���\t"+"��Ʒ��\t"+"����\t"+"������");
				
				for(int j=0;j<dishNames.length;j++){
					//������Ʒ��Ϣ
					
					System.out.println((j+1)+".\t"+dishNames[j]+"\t"+prices[j]+"Ԫ\t"+praiseNums[j]);
				}
				System.out.println("������Ҫ���޵Ĳ�Ʒ��ţ�");
				int numc=input.nextInt();
				//��������1
				praiseNums[numc-1]++;
				//��ʾ������Ϣ
				System.out.println("���޳ɹ���");
				System.out.println(dishNames[numc-1]+"\t"+prices[numc-1]+"Ԫ\t"+"��������"+praiseNums[numc-1]);
				break;
			case 6:
				isExit=true;
				break;
				default:
				isExit=true;
					break;
			}
		
			if(!isExit){	
				System.out.println("������0����:");
				 num=input.nextInt();
			}else{
				break;
			}
			
				
		}while(num==0);
		System.out.println("ллʹ�ã���ӭ�´ι���");
		
		
	}
}
