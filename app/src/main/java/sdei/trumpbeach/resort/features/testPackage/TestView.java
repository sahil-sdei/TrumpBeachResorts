package sdei.trumpbeach.resort.features.testPackage;

import sdei.trumpbeach.resort.features.internal.base.contract.Viewable;

/**
 * Created by G-Expo on 03 Mar 2017.
 */

public interface TestView extends Viewable<TestPresenter>
{

    void setReview(TestModel testModel);
}
