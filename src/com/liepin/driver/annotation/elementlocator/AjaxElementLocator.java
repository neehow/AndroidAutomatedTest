package com.liepin.driver.annotation.elementlocator;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.lang.reflect.Field;

import com.liepin.driver.annotation.PageElement;
import com.liepin.utils.Clock;
import com.liepin.utils.SystemClock;

public class AjaxElementLocator extends DefaultElementLocator {

    protected final int timeOutInSeconds;
    private final Clock clock;

    /**
     * Main constructor.
     * 
     * @param searchContext
     *            The context to use when finding the element
     * @param field
     *            The field representing this element
     * @param timeOutInSeconds
     *            How long to wait for the element to appear. Measured in
     *            seconds.
     */
    public AjaxElementLocator(SearchContext searchContext, Field field, int timeOutInSeconds) {
        this(new SystemClock(), searchContext, field, timeOutInSeconds);
    }

    public AjaxElementLocator(Clock clock, SearchContext searchContext, Field field, int timeOutInSeconds) {
        super(searchContext, field);
        this.timeOutInSeconds = timeOutInSeconds;
        this.clock = clock;
    }

    /**
     * {@inheritDoc}
     * 
     * Will poll the interface on a regular basis until the element is present.
     */
    @Override
    public PageElement findElement() {
        PageElement element;
        long end = clock.laterBy(SECONDS.toMillis(timeOutInSeconds));
        do {
            element = super.findElement();
        } while (clock.isNowBefore(end) && element.getView() == null);
        if (element.getView() == null)
            throw new NullPointerException();
        return element;
    }

    /**
     * By default, we sleep for 250ms between polls. You may override this
     * method in order to change how it sleeps.
     * 
     * @return Duration to sleep in milliseconds
     */
    protected long sleepFor() {
        return 250;
    }
}
