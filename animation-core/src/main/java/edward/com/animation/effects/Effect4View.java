package edward.com.animation.effects;

import android.animation.Animator;
import android.view.View;

public interface Effect4View {
    Animator[] getAnimators(View target);
    Effect4View setDuration(long duration);
}
