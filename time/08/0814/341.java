public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> q = new LinkedList<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        makelist(nestedList);
    }

    @Override
    public Integer next() {
        return q.poll();
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }
    public void makelist(List<NestedInteger> nestedList){
        for(NestedInteger ni:nestedList){
            if(ni.isInteger()){
                q.add(ni.getInteger());
            }
            else
                makelist(ni.getList());
        }
    }
}
