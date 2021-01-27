package us.cargosphere.automation.util;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * A class for Selenium utility methods.
 */
public class SeleniumUtil {

    // private constructor to prevent instantiating this utility class
    private SeleniumUtil() {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Gets the text from a given List of {@link WebElement}s and their descendant
     * nodes.
     * </p>
     * <p>
     * Strips the beginning and ending whitespace and replaces multiple spaces
     * "\s\s" with single spaces "\s" for the innerText.
     * </p>
     * 
     * @param elements         a list of {@link WebElement}s to retrieve the text
     *                         from.
     * @param includeHoverText If {@code true}, then any hovertext (css attribute
     *                         'title') from child nodes is added to the end of the
     *                         list.
     * @return a list of text with one entry per element from the input. null
     *         elements result in an empty string.
     */
    public static List<String> getText(List<WebElement> elements, boolean includeHoverText) {
        if (elements == null)
            return null;

        List<String> rtn = new ArrayList<>();
        for (WebElement el : elements) {
            if (el == null) {
                rtn.add("");
                continue;
            }

            String currentRowText = el.getAttribute("innerText");
            if (includeHoverText) {
                List<WebElement> childrenWithHovertext = el.findElements(By.cssSelector("[title]"));
                for (WebElement child : childrenWithHovertext) {
                    currentRowText += " " + child.getAttribute("title");
                }
            }
            rtn.add(currentRowText.trim().replaceAll(" +", " "));
        }
        return rtn;
    }

    /**
     * <p>
     * Gets the text from a given {@link WebElement} an all child nodes.
     * </p>
     * <p>
     * Strips the beginning and ending whitespace and replaces multiple spaces
     * "\s\s" with single spaces "\s" for the innerText.
     * </p>
     * 
     * @param element          a {@link WebElement} to retrieve the text from.
     * @param includeHoverText If {@code true}, then any hovertext (css attribute
     *                         'title') from child nodes is appended to the end of
     *                         the string.
     * @return the text from the given {@link WebElement} and descendants, space
     *         separated. Returns an empty string if the element is null.
     */
    public static String getText(WebElement element, boolean includeHoverText) {
        if (element == null)
            return "";

        String rtn = element.getAttribute("innerText");
        if (includeHoverText) {
            List<WebElement> childrenWithHovertext = element.findElements(By.cssSelector("[title]"));
            for (WebElement child : childrenWithHovertext) {
                rtn += " " + child.getAttribute("title");
            }
        }
        return rtn.trim().replaceAll(" +", " ");
    }

    public static WebElement findNullableElement(WebElement context, By by) {
        try {
            return context.findElement(by);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public static WebElement findNullableElement(WebDriver context, By by) {
        try {
            return context.findElement(by);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public static void dragAndDrop (WebDriver context, WebElement draggedElement, WebElement targetElement) {
        Actions builder = new Actions(context);

        Action dragAndDrop = builder.clickAndHold(draggedElement)
                .moveToElement(targetElement)
                .release(draggedElement)
                .build();

        dragAndDrop.perform();
    }

    public static void doubleClick(WebDriver context, WebElement target) {
        Actions builder = new Actions(context);
        builder.doubleClick(target).build().perform();
    }
}