package us.cargosphere.automation.pages.ratesearch;

/**
 * <p>
 * ResultsView is an interface representing a way of viewing the rate search
 * results in the UI.
 * </p>
 * 
 * <p>
 * For example, we currently have the Compact View and the Classic View which
 * are both implementations of the ResultsView.
 * </p>
 * 
 */
public interface ResultsView {

    /**
     * gets the number of search results
     * 
     * @return
     */
    public int getResultCount();
}
