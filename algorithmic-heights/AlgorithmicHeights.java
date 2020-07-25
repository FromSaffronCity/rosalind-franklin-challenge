package rosalind;

import java.util.Scanner;
import java.util.Vector;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

class AdjacencyListItem {
    public int index;
    public int weight;

    public AdjacencyListItem(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }
}

class Node {
    private int distance;
    private boolean isVisited;
    private Vector<AdjacencyListItem> adjacencyList;
    private int inDegree;

    public Node() {
        distance = -1;
        adjacencyList = new Vector<>();
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void addNeighbor(int index, int weight) {
        adjacencyList.add(new AdjacencyListItem(index, weight));
        return ;
    }

    public AdjacencyListItem[] getAdjacencyList() {
        AdjacencyListItem[] adjacencyList = new AdjacencyListItem[this.adjacencyList.size()];

        for(int i=0; i<adjacencyList.length; i++) {
            adjacencyList[i] = this.adjacencyList.get(i);
        }
        return adjacencyList;
    }

    public void setInDegree(int inDegree) {
        this.inDegree = inDegree;
        return ;
    }

    public int getInDegree() {
        return inDegree;
    }
}

class BinaryHeapItem {
    public int index;
    public int value;

    public BinaryHeapItem(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

class BinaryHeap {
    private int length;
    private BinaryHeapItem[] binaryHeap;
    private int[] positionArray;
    private boolean isMinHeap;

    public BinaryHeap(boolean isMinHeap) {
        binaryHeap = new BinaryHeapItem[2];
        positionArray = new int[2];
        this.isMinHeap = isMinHeap;
    }

    private void expand() {
        BinaryHeapItem[] tempBinaryHeap = new BinaryHeapItem[binaryHeap.length*2];
        int[] tempPositionArray = new int[positionArray.length*2];

        for(int i=0; i<binaryHeap.length; i++) {
            tempBinaryHeap[i] = binaryHeap[i];
            tempPositionArray[i] = positionArray[i];
        }
        binaryHeap = tempBinaryHeap;
        positionArray = tempPositionArray;
        return ;
    }

    private void siftUp(int position) {
        if(position == 0) {
            return ;
        }

        if(isMinHeap? binaryHeap[position].value<binaryHeap[(position-1)/2].value: binaryHeap[position].value>binaryHeap[(position-1)/2].value) {
            BinaryHeapItem temp = binaryHeap[position];
            binaryHeap[position] = binaryHeap[(position-1)/2];
            binaryHeap[(position-1)/2] = temp;
            positionArray[binaryHeap[position].index] = position;
            positionArray[binaryHeap[(position-1)/2].index] = (position-1)/2;
            siftUp((position-1)/2);
        }
        return ;
    }

    private void siftDown(int position) {
        if(position*2+1 >= length) {
            return ;
        }
        int parent = position;

        if(isMinHeap? binaryHeap[position].value>binaryHeap[parent*2+1].value: binaryHeap[position].value<binaryHeap[parent*2+1].value) {
            position = parent*2+1;
        }
        if((parent*2+2 < length) && (isMinHeap? binaryHeap[position].value>binaryHeap[parent*2+2].value: binaryHeap[position].value<binaryHeap[parent*2+2].value)) {
            position = parent*2+2;
        }
        if(parent != position) {
            BinaryHeapItem temp = binaryHeap[parent];
            binaryHeap[parent] = binaryHeap[position];
            binaryHeap[position]= temp;
            positionArray[binaryHeap[parent].index] = parent;
            positionArray[binaryHeap[position].index] = position;
            siftDown(position);
        }
        return ;
    }

    public int[] getBinaryHeap() {
        int[] temp = new int[length];
        for(int i=0; i<length; i++) {
            temp[i] = binaryHeap[i].value;
        }
        return temp;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public void put(BinaryHeapItem binaryHeapItem) {
        if(length == binaryHeap.length) {
            expand();
        }

        binaryHeap[length] = binaryHeapItem;
        positionArray[binaryHeapItem.index] = length++;
        return ;
    }

    public void heapify() {
        for(int i=(length/2-1); i>=0; i--) {
            siftDown(i);
        }
        return ;
    }

    public void putWithSiftUp(BinaryHeapItem binaryHeapItem) {
        if(length == binaryHeap.length) {
            expand();
        }

        binaryHeap[length] = binaryHeapItem;
        positionArray[binaryHeapItem.index] = length;
        siftUp(length++);
        return ;
    }

    public BinaryHeapItem get() {
        BinaryHeapItem temp = null;

        if(length != 0) {
            temp = binaryHeap[0];
            binaryHeap[0] = binaryHeap[--length];
            siftDown(0);
        }
        return temp;
    }

    public void decreaseKey(int index, int value) {
        int position = positionArray[index];
        if(binaryHeap[position].value > value) {
            binaryHeap[position].value = value;

            if(isMinHeap) {
                siftUp(position);
            } else {
                siftDown(position);
            }
        }
        return ;
    }
}

public class AlgorithmicHeights {
    private static Scanner scanner = new Scanner(System.in);

    private static int[] degreeArray(int nodes, int[][] edgeList) {
        int[] degreeArray = new int[nodes];
        for(int i=0; i<degreeArray.length; i++) {
            degreeArray[i] = 0;
        }

        for(int i=0; i<edgeList.length; i++) {
            degreeArray[edgeList[i][0]-1]++;
            degreeArray[edgeList[i][1]-1]++;
        }
        return degreeArray;
    }

    private static int[] doubleDegreeArray(int node, int[][] edgeList) {
        int[] degreeArray = degreeArray(node, edgeList);
        int[] doubleDegreeArray = new int[node];
        for(int i=0; i<doubleDegreeArray.length; i++) {
            doubleDegreeArray[i] = 0;
        }

        for(int i=0; i<edgeList.length; i++) {
            doubleDegreeArray[edgeList[i][0]-1] += degreeArray[edgeList[i][1]-1];
            doubleDegreeArray[edgeList[i][1]-1] += degreeArray[edgeList[i][0]-1];
        }
        return doubleDegreeArray;
    }

    private static int[] breadthFirstSearch(int node, int[][] edgeList) {
        Node[] nodes = new Node[node];
        for(int i=0; i<nodes.length; i++) {
            nodes[i] = new Node();
        }
        for(int i=0; i<edgeList.length; i++) {
            nodes[edgeList[i][0]-1].addNeighbor(edgeList[i][1]-1, 1);
        }
        int[] distances = new int[node];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        nodes[0].setDistance(0);
        nodes[0].setVisited(true);
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            AdjacencyListItem[] adjacencyList = nodes[temp].getAdjacencyList();

            for(int i=0; i<adjacencyList.length; i++) {
                if(!nodes[adjacencyList[i].index].isVisited()) {
                    nodes[adjacencyList[i].index].setDistance(nodes[temp].getDistance()+1);
                    nodes[adjacencyList[i].index].setVisited(true);
                    queue.add(adjacencyList[i].index);
                }
            }
        }

        for(int i=0; i<distances.length; i++) {
            distances[i] = nodes[i].getDistance();
        }
        return distances;
    }

    private static void depthFirstSearch(Node[] nodes, int current, boolean[] isInStack) {
        isInStack[current] = true;
        AdjacencyListItem[] adjacencyList = nodes[current].getAdjacencyList();

        for(int i=0; i<adjacencyList.length; i++) {
            if(!nodes[adjacencyList[i].index].isVisited() && !isInStack[adjacencyList[i].index]) {
                depthFirstSearch(nodes, adjacencyList[i].index, isInStack);
            }
        }
        isInStack[current] = false;
        nodes[current].setVisited(true);
        return ;
    }

    private static int connectedComponents(int node, int[][] edgeList) {
        Node[] nodes = new Node[node];
        for(int i=0; i<nodes.length; i++) {
            nodes[i] = new Node();
        }
        for(int i=0; i<edgeList.length; i++) {
            nodes[edgeList[i][0]-1].addNeighbor(edgeList[i][1]-1, 1);
            nodes[edgeList[i][1]-1].addNeighbor(edgeList[i][0]-1, 1);
        }
        int connected_components = 0;
        boolean[] isInStack = new boolean[node];
        for(int i=0; i<isInStack.length; i++) {
            isInStack[i] = false;
        }

        for(int i=0; i<nodes.length; i++) {
            if(!nodes[i].isVisited()) {
                connected_components++;
                depthFirstSearch(nodes, i, isInStack);
            }
        }
        return connected_components;
    }

    private static boolean depthFirstSearchAcyclic(Node[] nodes, int current, boolean[] isInStack) {
        boolean isCyclic = false;
        isInStack[current] = true;
        AdjacencyListItem[] adjacencyList = nodes[current].getAdjacencyList();

        for(int i=0; i<adjacencyList.length; i++) {
            if(!nodes[adjacencyList[i].index].isVisited()) {
                if(isInStack[adjacencyList[i].index]) {
                    isCyclic = true;
                    break ;
                }
                isCyclic = depthFirstSearchAcyclic(nodes, adjacencyList[i].index, isInStack);
            }
            if(isCyclic) {
                break ;
            }
        }
        if(!isCyclic) {
            isInStack[current] = false;
            nodes[current].setVisited(true);
        }
        return isCyclic;
    }

    private static int testingAcyclicity(int node, int[][] edgeList) {
        Node[] nodes = new Node[node];
        for(int i=0; i<nodes.length; i++) {
            nodes[i] = new Node();
        }
        for(int i=0; i<edgeList.length; i++) {
            nodes[edgeList[i][0]-1].addNeighbor(edgeList[i][1]-1, 1);
        }
        boolean isCyclic = false;
        boolean[] isInStack = new boolean[node];
        for(int i=0; i<isInStack.length; i++) {
            isInStack[i] = false;
        }

        for(int i=0; i<nodes.length; i++) {
            if(!nodes[i].isVisited()) {
                isCyclic = depthFirstSearchAcyclic(nodes, i, isInStack);
            }
            if(isCyclic) {
                break;
            }
        }
        return (isCyclic? -1: 1);
    }

    private static void depthFirstSearchTopologicalSorting(Node[] nodes, int current, Stack<Integer> stack) {
        AdjacencyListItem[] adjacencyList = nodes[current].getAdjacencyList();

        for(int i=0; i<adjacencyList.length; i++) {
            if(!nodes[adjacencyList[i].index].isVisited()) {
                depthFirstSearchTopologicalSorting(nodes, adjacencyList[i].index, stack);
            }
        }
        stack.push(current);
        nodes[current].setVisited(true);
        return ;
    }

    private static int[] topologicalSorting(int node, int[][] edgeList) {
        Node[] nodes = new Node[node];
        for(int i=0; i<nodes.length; i++) {
            nodes[i] = new Node();
        }
        for(int i=0; i<edgeList.length; i++) {
            nodes[edgeList[i][0]-1].addNeighbor(edgeList[i][1]-1, 1);
            nodes[edgeList[i][1]-1].setInDegree(nodes[edgeList[i][1]-1].getInDegree()+1);
        }
        Stack<Integer> stack = new Stack<>();
        Vector<Integer> zeroInDegree = new Vector<>();
        int[] topologicalOrdering = new int[node];
        for(int i=0; i<nodes.length; i++) {
            if(nodes[i].getInDegree() == 0) {
                zeroInDegree.add(i);
            }
        }

        for(Integer index: zeroInDegree) {
            depthFirstSearchTopologicalSorting(nodes, index, stack);
        }
        for(int i=0; i<topologicalOrdering.length; i++) {
            topologicalOrdering[i] = stack.pop()+1;
        }
        return topologicalOrdering;
    }

    private static int testingBipartiteness(int node, int[][] edgeList) {
        Node[] nodes = new Node[node];
        for(int i=0; i<nodes.length; i++) {
            nodes[i] = new Node();
        }
        for(int i=0; i<edgeList.length; i++) {
            nodes[edgeList[i][0]-1].addNeighbor(edgeList[i][1]-1, 1);
            nodes[edgeList[i][1]-1].addNeighbor(edgeList[i][0]-1, 1);
        }
        boolean isBipartite = true;

        Queue<Integer> queue = new LinkedList<>();
        nodes[0].setDistance(1);
        nodes[0].setVisited(true);
        queue.add(0);
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            AdjacencyListItem[] adjacencyList = nodes[temp].getAdjacencyList();

            for(int i=0; i<adjacencyList.length; i++) {
                if(nodes[adjacencyList[i].index].getDistance()==-1) {
                    nodes[adjacencyList[i].index].setDistance(1);
                    nodes[adjacencyList[i].index].setVisited(!nodes[temp].isVisited());
                    queue.add(adjacencyList[i].index);
                } else {
                    if(nodes[temp].isVisited() == nodes[adjacencyList[i].index].isVisited()) {
                        isBipartite = false;
                        break;
                    }
                }
            }
            if(!isBipartite) {
                queue.clear();
                break;
            }
        }
        return (isBipartite? 1: -1);
    }

    private static int[] dijkstraAlgorithm(int node, int[][] edgeList) {
        Node[] nodes = new Node[node];
        for(int i=0; i<nodes.length; i++) {
            nodes[i] = new Node();
        }
        for(int i=0; i<edgeList.length; i++) {
            nodes[edgeList[i][0]-1].addNeighbor(edgeList[i][1]-1, edgeList[i][2]);
        }
        int[] distances = new int[node];

        BinaryHeap priorityQueue = new BinaryHeap(true);
        for(int i=0; i<node; i++) {
            priorityQueue.put(new BinaryHeapItem(i, (i==0? 0: Integer.MAX_VALUE)));
        }
        priorityQueue.heapify();

        while(!priorityQueue.isEmpty()) {
            BinaryHeapItem temp = priorityQueue.get();
            nodes[temp.index].setVisited(true);
            if(temp.value != Integer.MAX_VALUE) {
                nodes[temp.index].setDistance(temp.value);
            }

            AdjacencyListItem[] adjacencyList = nodes[temp.index].getAdjacencyList();
            for(int i=0; i<adjacencyList.length; i++) {
                if(!nodes[adjacencyList[i].index].isVisited() && temp.value!=Integer.MAX_VALUE) {
                    priorityQueue.decreaseKey(adjacencyList[i].index, temp.value+adjacencyList[i].weight);
                }
            }
        }
        for(int i=0; i<distances.length; i++) {
            distances[i] = nodes[i].getDistance();
        }
        return distances;
    }

    private static int[] bellmanFordAlgorithm(int node, int[][] edgeList) {
        int[] shortestPaths = new int[node];
        for(int i=0; i<shortestPaths.length; i++) {
            shortestPaths[i] = (i==0? 0: Integer.MAX_VALUE);
        }

        for(int i=1; i<=(node-1); i++) {
            for(int j=0; j<edgeList.length; j++) {
                if(shortestPaths[edgeList[j][0]-1] != Integer.MAX_VALUE) {
                    shortestPaths[edgeList[j][1]-1] = (shortestPaths[edgeList[j][0]-1]+edgeList[j][2]<shortestPaths[edgeList[j][1]-1]? shortestPaths[edgeList[j][0]-1]+edgeList[j][2]: shortestPaths[edgeList[j][1]-1]);
                }
            }
        }
        return shortestPaths;
    }

    private static int negativeWeightCycle(int node, int[][] edgeList) {
        int[] shortestPaths = new int[node];
        for(int i=0; i<shortestPaths.length; i++) {
            shortestPaths[i] = 0;
        }
        for(int i=1; i<=(node-1); i++) {
            for(int j=0; j<edgeList.length; j++) {
                shortestPaths[edgeList[j][1]-1] = (shortestPaths[edgeList[j][0]-1]+edgeList[j][2]<shortestPaths[edgeList[j][1]-1]? shortestPaths[edgeList[j][0]-1]+edgeList[j][2]: shortestPaths[edgeList[j][1]-1]);
            }
        }

        boolean hasNegativeWeightCycle = false;
        for(int i=0; i<edgeList.length; i++) {
            if(shortestPaths[edgeList[i][0]-1] != Integer.MAX_VALUE) {
                if(shortestPaths[edgeList[i][0]-1]+edgeList[i][2]<shortestPaths[edgeList[i][1]-1]) {
                    hasNegativeWeightCycle = true;
                    break;
                }
            }
        }
        return (hasNegativeWeightCycle? 1: -1);
    }

    private static int[] shortestPathsinDAG(int node, int[][] edgeList) {
        Node[] nodes = new Node[node];
        for(int i=0; i<nodes.length; i++) {
            nodes[i] = new Node();
        }
        for(int i=0; i<edgeList.length; i++) {
            nodes[edgeList[i][0]-1].addNeighbor(edgeList[i][1]-1, edgeList[i][2]);
        }
        int[] topologicalOrdering = topologicalSorting(node, edgeList);
        int[] shortestPaths = new int[node];
        for(int i=0; i<shortestPaths.length; i++) {
            shortestPaths[i] = (i==0? 0: Integer.MAX_VALUE);
        }

        for(int i=0; i<topologicalOrdering.length; i++) {
            AdjacencyListItem[] adjacencyList = nodes[topologicalOrdering[i]-1].getAdjacencyList();
            for(AdjacencyListItem item: adjacencyList) {
                if(shortestPaths[topologicalOrdering[i]-1] != Integer.MAX_VALUE) {
                    shortestPaths[item.index] = (shortestPaths[topologicalOrdering[i]-1]+item.weight<shortestPaths[item.index]? shortestPaths[topologicalOrdering[i]-1]+item.weight: shortestPaths[item.index]);
                }
            }
        }
        return shortestPaths;
    }

    private static int[] buildingAHeap(int[] array) {
        BinaryHeap binaryHeap = new BinaryHeap(false);
        for(int i=0; i<array.length; i++) {
            binaryHeap.put(new BinaryHeapItem(i, array[i]));
        }
        binaryHeap.heapify();
        return binaryHeap.getBinaryHeap();
    }

    private static int[] heapSort(int[] array) {
        BinaryHeap binaryHeap = new BinaryHeap(true);
        for(int i=0; i<array.length; i++) {
            binaryHeap.put(new BinaryHeapItem(i, array[i]));
        }
        binaryHeap.heapify();

        int index = 0;
        while(!binaryHeap.isEmpty()) {
            array[index++] = binaryHeap.get().value;
        }
        return array;
    }

    private static int[] partialSort(int[] array, int limit) {
        BinaryHeap binaryHeap = new BinaryHeap(true);
        for(int i=0; i<array.length; i++) {
            binaryHeap.put(new BinaryHeapItem(i, array[i]));
        }
        binaryHeap.heapify();

        array = new int[limit];
        for(int i=0; i<array.length; i++) {
            array[i] = binaryHeap.get().value;
        }
        return array;
    }

    private static int binarySearch(int[] array, int low, int high, int key) {
        if(low <= high) {
            int mid = (low+high)/2;

            if(array[mid] == key) {
                return mid;
            } else if(array[mid] < key) {
                return binarySearch(array, mid+1, high, key);
            } else {
                return binarySearch(array, low, mid-1, key);
            }
        } else {
            return -1;
        }
    }

    private static Integer[] mergeTwoSortedArrays(Integer[] array1, Integer[] array2) {
        int index=0, index1=0, index2=0;
        Integer[] mergedArray = new Integer[array1.length+array2.length];

        while(index1<array1.length && index2<array2.length) {
            if(array1[index1] < array2[index2]) {
                mergedArray[index++] = array1[index1++];
            } else {
                mergedArray[index++] = array2[index2++];
            }
        }
        if(index1 == array1.length) {
            for(int i=index2; i<array2.length; i++) {
                mergedArray[index++] = array2[i];
            }
        } else {
            for(int i=index1; i<array1.length; i++) {
                mergedArray[index++] = array1[i];
            }
        }
        return mergedArray;
    }

    private static int[] mergeSort(int[] array) {
        Queue<Integer[]> queue = new LinkedList<>();

        for(int i=0; i<array.length; i++) {
            queue.add(new Integer[]{array[i]});
        }
        while(queue.size() != 1) {
            queue.add(mergeTwoSortedArrays(queue.poll(), queue.poll()));
        }

        Integer[] temp = queue.poll();
        for(int i=0; i<array.length; i++) {
            array[i] = temp[i];
        }
        return array;
    }

    private static int majorityElement(int[] array) {
        array = mergeSort(array);
        int majority_element=-1, current=array[0], count=0;

        for(int i=0; i<array.length; i++) {
            if(array[i] == current) {
                count++;
                if(count > array.length/2) {
                    majority_element = current;
                    break;
                }
            } else {
                current = array[i];
                count = 1;
            }
        }
        return majority_element;
    }

    private static long mergeCountingInversions(int[] array, int left_min, int left_max, int right_min, int right_max) {
        int[] temp = new int[(right_max-left_min)+1];
        int index=0, index1=left_min, index2=right_min;
        long inversions = 0;

        while(index1<=left_max && index2<=right_max) {
            if(array[index1] > array[index2]) {
                inversions += (left_max-index1+1);
                temp[index++] = array[index2++];
            } else {
                temp[index++] = array[index1++];
            }
        }
        if(index1 > left_max) {
            for(int i=index2; i<=right_max; i++) {
                temp[index++] = array[i];
            }
        } else {
            for(int i=index1; i<=left_max; i++) {
                temp[index++] = array[i];
            }
        }
        for(int i=left_min, j=0; i<=right_max; i++, j++) {
            array[i] = temp[j];
        }
        return inversions;
    }

    private static long countingInversions(int[] array, int left, int right) {
        if(left < right) {
            return countingInversions(array, left, (left+right)/2)+countingInversions(array, (left+right)/2+1, right)+mergeCountingInversions(array, left, (left+right)/2, (left+right)/2+1, right);
        }
        return 0;
    }

    private static int[] twoSUM(int[] array) {
        /* not passed yet */
        BinaryHeap binaryHeap = new BinaryHeap(true);
        for(int i=0; i<array.length; i++) {
            binaryHeap.put(new BinaryHeapItem(i, array[i]));
        }
        binaryHeap.heapify();

        BinaryHeapItem[] temp = new BinaryHeapItem[array.length];
        for(int i=0; i<temp.length; i++) {
            temp[i] = binaryHeap.get();
            array[i] = temp[i].value;
        }

        int[] result = null;
        for(int i=0, index; i<array.length; i++) {
            index = binarySearch(array, 0, array.length-1, 0-array[i]);
            if(index != -1) {
                result = new int[2];
                result[0] = (temp[i].index+1<temp[index].index+1? temp[i].index+1: temp[index].index+1);
                result[1] = (temp[i].index+1>=temp[index].index+1? temp[i].index+1: temp[index].index+1);
                break;
            }
        }
        if(result == null) {
            result = new int[1];
            result[0] = -1;
        }
        return result;
    }

    public static void main(String[] args) {

        return ;
    }
}
