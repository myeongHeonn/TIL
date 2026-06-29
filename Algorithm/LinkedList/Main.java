public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("=== 연결 리스트 기본 연산 예제 ===\n");

        // 맨 뒤에 추가
        System.out.println("1. 맨 뒤에 추가: 10, 20, 30");
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.display();

        // 맨 앞에 추가
        System.out.println("\n2. 맨 앞에 추가: 5");
        list.insertAtBeginning(5);
        list.display();

        // 특정 위치에 추가
        System.out.println("\n3. 위치 2에 추가: 15");
        list.insertAtPosition(15, 2);
        list.display();

        // 리스트 크기
        System.out.println("\n4. 리스트 크기: " + list.size());

        // 검색
        System.out.println("\n5. 값 검색");
        System.out.println("15 검색: " + list.search(15));
        System.out.println("100 검색: " + list.search(100));

        // 맨 앞 삭제
        System.out.println("\n6. 맨 앞 노드 삭제");
        list.deleteAtBeginning();
        list.display();

        // 특정 값으로 삭제
        System.out.println("\n7. 값 20 삭제");
        list.deleteByValue(20);
        list.display();

        // 특정 위치 삭제
        System.out.println("\n8. 위치 1 삭제");
        list.deleteAtPosition(1);
        list.display();

        // 맨 뒤 삭제
        System.out.println("\n9. 맨 뒤 노드 삭제");
        list.deleteAtEnd();
        list.display();

        // 리스트 비우기
        System.out.println("\n10. 리스트 비우기");
        list.clear();
        list.display();
    }
}
