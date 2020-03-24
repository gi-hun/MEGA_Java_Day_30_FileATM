// # ���� ��Ʈ�ѷ�[2�ܰ�] : ATM
package day_30;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileEx07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = 5;
		int count = 0;
		int log = -1;
		
		String[] accs = new String[size];
		String[]  pws = new String[size];
		int[]  moneys = new int[size];
		
		String fileName = "atm.txt";
		
		while(true) {
			
			System.out.println("----------");
			for(int i=0;i<count;i++)
			{
				System.out.println(accs[i]+":"+pws[i]+":"+moneys[i]);
			}
			System.out.println("----------");
			if(log == -1)
			{
				System.out.println("����: �α׾ƿ�");
			}
			else
			{
				System.out.println("����:"+accs[log]+"�� �α���");
			}
			
			System.out.println("[MEGA ATM]");
			System.out.println("[1]ȸ������");
			System.out.println("[2]ȸ��Ż��");
			System.out.println("[3]�α���");
			System.out.println("[4]�α׾ƿ�");
			System.out.println("[5]�Ա�");
			System.out.println("[6]���");
			System.out.println("[7]��ü");
			System.out.println("[8]�ܾ���ȸ");
			System.out.println("[9]����");
			System.out.println("[10]�ε�");
			System.out.println("[0]����");
			
			System.out.print("�޴� ���� : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {		//ȸ������
				System.out.print("[����]���¹�ȣ �Է�:");
				String acc = sc.next();
				
				int check = 1;
				for(int i=0;i<count;i++)
				{
					if(accs[i].equals(acc))
					{
						check = -1;
					}
				}
				
				if(check == 1)
				{
					if(count==5)
					{
						System.out.println("[�޼���]���̻� ������ �� �����ϴ�.");
						continue;
					}
					System.out.print("[����]��й�ȣ �Է�:");
					String pw = sc.next();
					
					accs[count] = acc;
					pws[count] = pw;
					moneys[count] = 1000;
					
					count++;
					System.out.println("[�޼���]ȸ�������� �����մϴ�.");
				}
				else
				{
					System.out.println("[�޼���]���¹�ȣ�� �ߺ��˴ϴ�.");
				}
			}
			else if(sel == 2) {		//ȸ��Ż��
				if(log != -1)
				{
					for(int i=log;i<count-1;i++)
					{
						accs[i] = accs[i+1];
						pws[i] = pws[i+1];
						moneys[i] = moneys[i+1];
					}
					count--;
					log--;
					System.out.println("[�޼���]Ż��Ǿ����ϴ�.");
				}
				else
				{
					System.out.println("[�޼���]�α��� �� �̿밡���մϴ�.");
				}
			}
			else if(sel == 3) {
				if(log == -1)
				{
					System.out.print("[�α���]���¹�ȣ�� �Է�:");
					String acc = sc.next();
					
					System.out.print("[�α���]��й�ȣ �Է�");
					String pw = sc.next();
					
					for(int i=0;i<count;i++)
					{
						if(accs[i].equals(acc) && pws[i].equals(pw))
						{
							log = i;
						}
					}
					
					if(log == -1)
					{
						System.out.println("[�޼���]���¹�ȣ�� ��й�ȣ�� Ȯ�����ּ���");
					}
				}
				else
				{
					System.out.println("[�޼���]"+accs[log]+"�� �α��� ��...");
				}
			}
			else if(sel == 4) {
				if(log == -1)
				{
					System.out.println("[�޼���]�α��� �� �̿밡���մϴ�.");
				}
				else
				{
					log--;
					System.out.println("[�޼���]�α׾ƿ� �Ǿ����ϴ�.");
				}
			}
			else if(sel == 5) {
				if(log != -1)
				{
					System.out.println("[�Ա�]�ݾ� �Է�:");
					int money = sc.nextInt();
					
					moneys[log] += money;
					System.out.println("[�޼���]�Ա��� �Ϸ��Ͽ����ϴ�.");
				}
				else
				{
					System.out.println("[�޼���]�α��� �� �̿밡���մϴ�.");
				}
			}
			else if(sel == 6) {
				if(log != -1)
				{
					System.out.println("[���]�ݾ� �Է�:");
					int money = sc.nextInt();
					
					if(moneys[log]>=money)
					{
						moneys[log] -= money;
						System.out.println("[�޼���]����� �Ϸ��Ͽ����ϴ�.");
					}
					else
					{
						System.out.println("[�޼���]�α��� �� �̿밡���մϴ�.");
					}
				}
				else
				{
					System.out.println("[�޼���]�α��� �� �̿밡���մϴ�.");
				}
			}
			else if(sel == 7) {
				if(log != -1)
				{
					System.out.println("[��ü]���¹�ȣ �Է�");
					String acc = sc.next();
					
					int check = -1;
					for(int i=0;i<count;i++)
					{
						if(accs[i].equals(acc))
						{
							check = i;
						}
					}
					
					if(check != -1)
					{
						System.out.print("[��ü]�ݾ� �Է�:");
						int money = sc.nextInt();
						
						if(moneys[log]>=money)
						{
							moneys[log] -= money;
							moneys[check] += money;
							System.out.println("[�޼���]��ü�� �Ϸ��Ͽ����ϴ�.");
						}
						else
						{
							System.out.println("[�޼���]�ܾ��� �����մϴ�.");
						}
					}
					else
					{
						System.out.println("[�޼���]�α��� �� �̿밡���մϴ�.");
					}
					
				}
				else
				{
					System.out.println("[�޼���]�α��� �� �̿밡���մϴ�.");
				}
			}
			else if(sel == 8) {
				if(log != -1)
				{
					System.out.println(accs[log] + "���� ���� �ܾ���" + moneys[log] + "�� �Դϴ�.");
				}
				else
				{
					System.out.println("[�޼���]�α��� �� �̿밡���մϴ�.");
				}
			}
			else if(sel == 9) {
				if(count==0)
				{
					System.out.println("[�޼���]������ �����Ͱ� �����ϴ�.");
					continue;
				}
				String data="";
				for(int i=0;i<count;i++)
				{
					data += accs[i];
					data += "/";
					data += pws[i];
					data += "/";
					data += moneys[i];
					data += "\n";
				}
				
				data = data.substring(0, data.length()-1);
				
				FileWriter fw = null;
				try
				{
					fw = new FileWriter(fileName);
					fw.write(data);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if(fw != null)
					{
						try
						{
							fw.close();
						}
						catch(IOException e)
						{
						}
					}
				}
			}
			else if(sel == 10) {
				File file = new File(fileName);
				if(file.exists())
				{
					FileReader fr = null;
					BufferedReader br = null;
					try
					{
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						String data = "";
						while(true)
						{
							String line = br.readLine();
							if(line == null)
							{
								break;
							}
							data += line;
							data += "\n";
						}
						data = data.substring(0, data.length()-1);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						if(fr != null){try{fr.close();}catch(IOException e) {}}
						if(fr != null){try{br.close();}catch(IOException e) {}}
					}
				}
			}
			else if(sel == 0) {
				System.out.println("[�޼���]���α׷� ����");
				break;
			}
			
		}

	}
}
