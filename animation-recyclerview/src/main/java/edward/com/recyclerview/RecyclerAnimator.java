package edward.com.recyclerview;

import android.support.v7.widget.RecyclerView;

import edward.com.animation.AnimatorManager;
import edward.com.animation.effects.Action;
import edward.com.animation.effects.EffectHasDirection;

public class RecyclerAnimator extends BaseItemAnimator {

    private EffectHasDirection effectHasDirection;

    public RecyclerAnimator(EffectHasDirection effectHasDirection) {
        this.effectHasDirection = effectHasDirection;
    }

    @Override
    protected void animateRemoveImpl(RecyclerView.ViewHolder holder) {
        setEffectForReMove();
        animateView(holder);
        mRemoveAnimations.add(holder);
    }

    @Override
    protected void animateAddImpl(RecyclerView.ViewHolder holder) {
        setEffectForAdd();
        animateView(holder);
        mAddAnimations.add(holder);
    }

    private void setEffectForReMove(){
        effectHasDirection.setDuration(getRemoveDuration());
        effectHasDirection.setAction(Action.OUT);
    }

    private void setEffectForAdd(){
        effectHasDirection.setDuration(getAddDuration());
        effectHasDirection.setAction(Action.IN);
    }

    private void animateView(RecyclerView.ViewHolder holder){
        AnimatorManager.with(holder.itemView)
                .putEffect(effectHasDirection).animate();
    }
}