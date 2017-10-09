public class Bucket {
    LList[] bucket;
    int size;
    int digits;
    int bucketSize;

    public Bucket(String[] numbers, int len) {
        int num, mod;
        bucketSize = 10;
        bucket = new LList[bucketSize];
        size = numbers.length;
        digits = len;

        for(int i = 0; i < numbers.length; i++) {
            num = Integer.parseInt(numbers[i]);
            mod = num % 10;
            // If LList has Node
            if (bucket[mod] == null) {

                // Create Linked List and Node
                LList node = new LList();
                node.first = new Node(num);

                // Assign to LList array
                bucket[mod] = node;
            } else {
                // Enqueue Node
                bucket[mod].enqueue(new Node(num));
            }
        }

        sort(2);
    }

    public void sort(int len) {
        if ( len > digits ) {
            return;
        }

        int[] temp = new int[size];
        int num, mod;

        // valueToArray
        Node T = null;
        int i = 0;
        int index = 0;

        while (true) {
            if ( i >= bucketSize ) break;

            if ( bucket[i] == null ) {
                i++; continue;
            }

            if (T == null) {
                T = bucket[i].first;
            }

            temp[index] = T.id;
            index++;

            if ( T.next == null ) {
                i++;
                T = null;
                continue;
            }

            T = T.next;
        }

        // Remove LList
        bucket = new LList[bucketSize];

        // Sort
        for(i = 0; i < size; i++) {
            num = temp[i];
            mod = (int) (num / Math.pow(10, len - 1)) % 10;

            // If LList has Node
            if (bucket[mod] == null) {

                // Create Linked List and Node
                LList node = new LList();
                node.first = new Node(num);

                // Assign to LList array
                bucket[mod] = node;
            } else {
                // Enqueue Node
                bucket[mod].enqueue(new Node(num));
            }
        }

        sort(len + 1);
    }

    public void printBucket() {
        Node T = null;
        int i = 0;

        while (true) {
            if ( i >= bucketSize ) break;

            if ( bucket[i] == null ) {
                i++; continue;
            }

            if (T == null) {
                T = bucket[i].first;
            }

            System.out.println(String.format("%03d", T.id));

            if ( T.next == null ) {
                i++;
                T = null;
                continue;
            }

            T = T.next;
        }
    }
}
