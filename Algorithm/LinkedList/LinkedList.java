public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // 맨 앞에 노드 추가
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 맨 뒤에 노드 추가
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // 특정 위치에 노드 추가 (0부터 시작)
    public void insertAtPosition(int data, int position) {
        if (position < 0) {
            System.out.println("유효하지 않은 위치입니다.");
            return;
        }

        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;

        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("위치가 리스트 범위를 초과합니다.");
                return;
            }
            current = current.next;
        }

        if (current == null) {
            System.out.println("위치가 리스트 범위를 초과합니다.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // 맨 앞의 노드 삭제
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("빈 리스트입니다.");
            return;
        }
        head = head.next;
    }

    // 맨 뒤의 노드 삭제
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("빈 리스트입니다.");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // 특정 값의 노드 삭제
    public void deleteByValue(int data) {
        if (head == null) {
            System.out.println("빈 리스트입니다.");
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        System.out.println(data + "는 리스트에 없습니다.");
    }

    // 특정 위치의 노드 삭제
    public void deleteAtPosition(int position) {
        if (head == null || position < 0) {
            System.out.println("유효하지 않은 위치입니다.");
            return;
        }

        if (position == 0) {
            deleteAtBeginning();
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("위치가 리스트 범위를 초과합니다.");
                return;
            }
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("위치가 리스트 범위를 초과합니다.");
            return;
        }

        current.next = current.next.next;
    }

    // 특정 값 검색
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 리스트 출력
    public void display() {
        if (head == null) {
            System.out.println("빈 리스트입니다.");
            return;
        }

        Node current = head;
        System.out.print("LinkedList: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 리스트 크기
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // 리스트 비우기
    public void clear() {
        head = null;
    }
}
