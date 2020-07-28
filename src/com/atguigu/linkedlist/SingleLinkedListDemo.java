package com.atguigu.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {

		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2 = new HeroNode(2, "¬����", "������");
		HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");


		SingleLinkedList singleLinkedList = new SingleLinkedList();

//		singleLinkedList.addToRear(hero1);
//		singleLinkedList.addToRear(hero4);
//		singleLinkedList.addToRear(hero2);
//		singleLinkedList.addToRear(hero3);

		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero3);
//		singleLinkedList.addByOrder(hero2);

		singleLinkedList.list();
		System.out.println();

		System.out.println("��ת������~~");
		reversetList(singleLinkedList.getHead());
		singleLinkedList.list();
		System.out.println();

//		System.out.println("���������ӡ������, û�иı�����Ľṹ~~");
//		reversePrint(singleLinkedList.getHead());
//		System.out.println();

		singleLinkedList.list();
		System.out.println();


//		singleLinkedList.update(new HeroNode(2, "С¬", "������~~"));
//
//		singleLinkedList.list();
//		System.out.println();
//
//		singleLinkedList.del(1);
//		singleLinkedList.del(4);
//		singleLinkedList.del(4);
//
//		singleLinkedList.list();
//		System.out.println();
	}

	/**
	 * ��������ת��ӡ�������ƻ�ԭ��������ṹ
	 */
	public static void reversePrint(HeroNode head) {
		HeroNode cur = head.next;

		Stack<HeroNode> stack = new Stack<HeroNode>();

		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}

		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

	/**
	 * ��������ת
	 */
	public static void reversetList(HeroNode head) {
		HeroNode reverseHead = new HeroNode(0, "", "");
		HeroNode cur = head.next;
		HeroNode next = null;

		while (cur != null) {
			next = cur.next;

			cur.next = reverseHead.next;
			reverseHead.next = cur;

			cur = next;
		}

		head.next = reverseHead.next;
	}

	/**
	 * ���ҵ������еĵ�����index����� �����������⡿
	 */
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		int length = getLength(head);

		if (index <= 0 || index > length) {
			return null;
		}

		HeroNode cur = head.next;
		for (int i = 0; i < length - index; i++) {
			cur = cur.next;
		}

		return cur;
	}

	/**
	 * ���صľ�����Ч�ڵ�ĸ���
	 */
	public static int getLength(HeroNode head) {
		HeroNode cur = head.next;

		int count = 0;

		while (cur != null) {
			count++;
			cur = cur.next;
		}

		return count;
	}

}


class SingleLinkedList {

	private HeroNode head = new HeroNode(0, "", "");

	public HeroNode getHead() {
		return this.head;
	}

	/**
	 * ��ӵ�ĩβ
	 */
	public void addToRear (HeroNode newHeroNode) {
		HeroNode tmp = this.head;

		while (true) {
			if (tmp.next == null) {
				break;
			}

			tmp = tmp.next;
		}

		tmp.next = newHeroNode;
	}

	/**
	 * ��˳�����
	 */
	public void addByOrder (HeroNode newHeroNode) {
		HeroNode tmp = this.head;

		boolean flag = false; //�Ƿ������ͬno�Ľڵ�

		while (true) {
			if (tmp.next == null) {
				break;
			}

			if (newHeroNode.no == tmp.next.no) {
				flag = true;
				break;
			}

			if (newHeroNode.no < tmp.next.no) {
				break;
			}

			tmp = tmp.next;
		}

		if (flag) {
			System.out.printf("������ͬ�ڵ�:%d���޷����\n", newHeroNode.no);
		} else {
			newHeroNode.next = tmp.next;
			tmp.next = newHeroNode;
		}
	}

	public void update(HeroNode newHeroNode) {
		HeroNode tmp = this.head.next;

		boolean hasNode = false;

		while (true) {
			if (tmp == null) {
				break;
			}

			if (newHeroNode.no == tmp.no) {
				hasNode = true;
				break;
			}

			tmp = tmp.next;
		}

		if (hasNode) {
			tmp.name = newHeroNode.name;
			tmp.nickname = newHeroNode.nickname;
		} else {
			System.out.printf("û���ҵ� ��� %d �Ľڵ㣬�����޸�\n", newHeroNode.no);
		}
	}

	public void del (int no) {
		HeroNode tmp = head;

		boolean hasNode = false;

		while (true) {
			if (tmp.next == null) {
				break;
			}

			if (no == tmp.next.no) {
				hasNode = true;
				break;
			}

			tmp = tmp.next;
		}

		if (hasNode) {
			tmp.next = tmp.next.next;
		} else {
			System.out.printf("Ҫɾ���� %d �ڵ㲻����\n", no);
		}
	}

	public void list () {
		HeroNode tmp = this.head.next;

		while (true) {
			if (tmp == null)
				break;

			System.out.println(tmp);

			tmp = tmp.next;
		}
	}
}


class HeroNode {

	public int no;

	public String name;

	public String nickname;

	public HeroNode next;

	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}



}







