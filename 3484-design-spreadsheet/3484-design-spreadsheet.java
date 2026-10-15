/*
26 columns labeled from A - Z and a given number of rows
Each cell in the spreadsheet can hold an integer value between 0 and 10^5
*/
class Spreadsheet {

    HashMap<String, Integer> map;

    public Spreadsheet(int rows) {
        map = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        map.put(cell, value);
    }
    
    public void resetCell(String cell) {
        map.put(cell, 0);
    }
    
    public int getValue(String formula) {
        String expression = formula.substring(1);
        String[] parts = expression.split("\\+"); 
        String x = parts[0];
        String y = parts[1];
        return evaluate(x) + evaluate(y);
    }
    
    private int evaluate(String s) {
    // Check if the first character is a letter (meaning it's a cell like "A1")
    if (Character.isLetter(s.charAt(0))) {
        // Fetch from the map, defaulting to 0 if it hasn't been set yet
        return map.getOrDefault(s, 0); 
    } else {
        // It's a raw number, so parse it directly
        return Integer.parseInt(s);
    }
}
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */