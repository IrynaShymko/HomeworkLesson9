package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    private WebDriver driver;
    private WebElement tableElement;

    public Table(WebElement tableElement, WebDriver driver) {
        this.tableElement = tableElement;
        this.driver = driver;
    }

    public List<WebElement> getRows() {
        List<WebElement> rows = tableElement.findElements(By.xpath(".//tbody//tr"));
        return rows;
    }
    public List<WebElement> getRanks() {
        List<WebElement> ranks = tableElement.findElements(By.xpath(".//tbody//th"));
        return ranks;
    }


    public List<WebElement> getHeadings() {
        WebElement headingsRow = tableElement.findElement(By.xpath(".//thead//tr"));
        List<WebElement> headingColumns = headingsRow.findElements(By.xpath(".//th"));
        headingColumns.remove(0);
        return headingColumns;
    }

    public List<List<WebElement>> getRowsWithColumns() {
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for (WebElement row : rows) {
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }

    public List<Map<String, WebElement>> getRowsWithColumnsByHeading() {
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        List<Map<String, WebElement>> rowsWithColumnsByHeading = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeadings;
        List<WebElement> headingsColumns = getHeadings();
        for (List<WebElement> row : rowsWithColumns) {
            rowByHeadings = new HashMap<String, WebElement>();
            for (int i = 0; i < headingsColumns.size(); i++) {
                String heading = headingsColumns.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeadings.put(heading, cell);
            }
            rowsWithColumnsByHeading.add(rowByHeadings);
        }
        return rowsWithColumnsByHeading;
    }

    public String getValueFromCellByHeading(int rowNumber, String columnName) {
        List<Map<String, WebElement>> rowsWithColumnsByHeading = getRowsWithColumnsByHeading();
        return rowsWithColumnsByHeading.get(rowNumber - 1).get(columnName).getText();
    }

    public void showInfoAboutMountainsByStateAndHeight(String stateName, int chosenHeight) {
        List<WebElement> rows = getRows();
        for (int i = 0; i < rows.size(); i++) {
            String name = getValueFromCellByHeading(i+1, "State");
            if (name.contains(stateName)) {
                int height = Integer.parseInt(getValueFromCellByHeading(i+1, "Height"));
                if (height > chosenHeight) {
                    System.out.println("Rank "+getRanks().get(i).getText()+", Peak - " + getValueFromCellByHeading(i+1, "Peak") +
                            ", Mountain range - " + getValueFromCellByHeading(i+1, "Mountain range"));
                }
            }
        }
    }
}

