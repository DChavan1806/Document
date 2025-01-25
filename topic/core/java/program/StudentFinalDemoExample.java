package topic.core.java.program;

import java.util.HashMap;
import java.util.Map;

final class StudentFinalDemoExample {
    final String rollNumber;
    final Map<String, String> gradesPerSubj;

    public StudentFinalDemoExample(String rollNumber, Map<String, String> gradesPerSubj)
    {
        this.rollNumber = rollNumber;
        this.gradesPerSubj = new HashMap<>(gradesPerSubj);
    }

    public String getRollNumber()
    {
        return this.rollNumber;
    }

    public Map<String, String> gradesPerSubj()
    {
        return new HashMap<>(gradesPerSubj);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        StudentFinalDemoExample that = (StudentFinalDemoExample) obj;
        return this.rollNumber.equals(that.rollNumber);
    }

    @Override
    public int hashCode() {
        return rollNumber != null ? rollNumber.hashCode() : 0;
    }

    public String toString()
    {
        return rollNumber;
    }
}