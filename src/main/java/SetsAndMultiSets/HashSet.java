package SetsAndMultiSets;
import java.util.HashSet;

class Set extends HashSet<String> {
    private static final long serialVersionUID = 1L;

    public Set() {
        super();
    }

    /**
     * @return the union of the elements of this and that
     */
    public Set union(Set that) {
        Set result = new Set();
        if (that == null) {
            result.addAll(this);
        } else {
            result.addAll(this);
            result.addAll(that);
        }
        return result;
    }

    /**
     * @return the intersection of the elements of this and that
     */
    public Set intersection(Set that) {
        Set result = new Set();
        if (that != null) {
            for (String s : that) {
                if (this.contains(s)) {
                    result.add(s);
                }
            }
        }
        return result;
    }

    /**
     * @return the difference of the elements of this and that
     */
    public Set difference(Set that) {
        Set result = new Set();
        if (that == null) result.addAll(this);
        else {
            for (String s : this) {
                if (!that.contains(s)) {
                    result.add(s);
                }
            }
        }
        return result;
    }

    /**
     * @return the exclusive or (XOR) of the elements of this and that
     */
    // all elements in this and that , that are not in intersection
    public Set exclusiveOr(Set that) {
        Set result = difference(that);
        if (that == null) return result;
        else{
            for (String s : that){
                if (!this.contains(s)){
                    result.add(s);
                }
            }
            return result;
        }
    }

    /**
     * @return a String representation of a MySet object
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("<MySet{");
        int sz = size();
        int currIndex = 0;
        for (String s : this) {
            if (currIndex - 1 == sz) sb.append(s);
            else sb.append(s + ",");
        }
        sb.append("}>");
        return sb.toString();
    }
}
