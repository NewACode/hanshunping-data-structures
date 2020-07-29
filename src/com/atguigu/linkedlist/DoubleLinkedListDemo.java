package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {

		HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
		HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
		HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
		HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");

		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

		doubleLinkedList.addByOrder(hero4);
		doubleLinkedList.addByOrder(hero1);
		doubleLinkedList.addByOrder(hero3);
		doubleLinkedList.addByOrder(hero2);
//		doubleLinkedList.addByOrder(hero2);

		doubleLinkedList.listPrint();
		System.out.println();

		doubleLinkedList.reverseListPrint();
		System.out.println();


//		doubleLinkedList.del(3);
//		doubleLinkedList.del(2);
//		doubleLinkedList.del(1);
//		doubleLinkedList.del(4);

		doubleLinkedList.reverseList();


		doubleLinkedList.listPrint();
		System.out.println();

		doubleLinkedList.reverseListPrint();
		System.out.println();


	}

}

class DoubleLinkedList {

	private HeroNode2 head = new HeroNode2(0, "", "");

	public HeroNode2 getHead() {
		return head;
	}

	public void listPrint () {
		HeroNode2 cur = head.next;

		while (true) {
			if (cur == null) {
				break;
			}

			System.out.println(cur);

			cur = cur.next;
		}
	}

	public void reverseListPrint () {
		HeroNode2 cur = head;

		while (true) {
			if (cur.next == null) {
				break;
			}

			cur = cur.next;
		}

		while (true) {
			if (cur == head) {
				break;
			}

			System.out.println(cur);

			cur = cur.pre;
		}
	}

	/**
	 * ��ӵ�ĩβ
	 */
	public void addToRear (HeroNode2 newHeroNode) {
		HeroNode2 cur = head;

		while (true) {
			if (cur.next == null) {
				break;
			}

			cur = cur.next;
		}

		cur.next = newHeroNode;
		newHeroNode.pre = cur;
	}

	/**
	 * ��˳�����
	 */
	public void addByOrder (HeroNode2 newHeroNode) {
		HeroNode2 cur = head;

		boolean flag = false;

		while (true) {
			if (cur.next == null) {
				break;
			}

			if (newHeroNode.no < cur.next.no) {
				break;
			}

			if (newHeroNode.no == cur.next.no) {
				flag = true;
				break;
			}

			cur = cur.next;
		}

		if (flag) {
			System.out.printf("������ͬ�ڵ�:%d���޷����\n", newHeroNode.no);
		} else {
			newHeroNode.next = cur.next;
			cur.next = newHeroNode;

			newHeroNode.pre = cur;

			if (newHeroNode.next != null) {
				newHeroNode.next.pre = newHeroNode;
			}
		}
	}

	public void update(HeroNode2 newHeroNode) {
		HeroNode2 temp = head.next;

		boolean flag = false; //��ʾ�Ƿ��ҵ��ýڵ�

		while (true) {
			if (temp == null) {
				break; //�Ѿ�����������
			}

			if (newHeroNode.no == temp.no) {
				flag = true;
				break;
			}

			temp = temp.next;
		}

		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else { // û���ҵ�
			System.out.printf("û���ҵ� ��� %d �Ľڵ㣬�����޸�\n", newHeroNode.no);
		}
	}

	public void del(int no) {
		HeroNode2 cur = head.next;

		boolean hasNode = false;

		while (true) {
			if (cur == null) {
				break;
			}

			if (no == cur.no) {
				hasNode = true;
				break;
			}

			cur = cur.next;
		}

		if (hasNode) {
			cur.pre.next = cur.next;

			if (cur.next != null) {
				cur.next.pre = cur.pre;
			}
		} else {
			System.out.printf("�ڵ�%d������\n", no);
		}
	}

	public void reverseList() {
		HeroNode2 reverseHead = new HeroNode2(0, "", "");
		HeroNode2 cur = this.head.next;
		HeroNode2 next = null;

		while (cur != null) {
			next = cur.next;

			cur.next = reverseHead.next;
			reverseHead.next = cur;

			cur.pre = reverseHead;

			if (cur.next != null) {
				cur.next.pre = cur;
			}

			cur = next;
		}

		this.head.next = reverseHead.next;

		if (reverseHead.next != null) {
			reverseHead.next.pre = this.head;
		}
	}
}


class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next; // ָ����һ���ڵ�, Ĭ��Ϊnull
	public HeroNode2 pre; // ָ��ǰһ���ڵ�, Ĭ��Ϊnull

	public HeroNode2(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}







































