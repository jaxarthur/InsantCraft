package dev.jaxarthur.instantcraft.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.recipe.Recipe;
import net.minecraft.screen.slot.SlotActionType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerInteractionManager.class)
public class InstantCraftMixin {

    @Shadow @Final private MinecraftClient client;

    @Inject(at = @At("TAIL"), method = "clickRecipe")
    private void clickRecipe(int syncId, Recipe<?> recipe, boolean craftAll, CallbackInfo info) {
        if (craftAll) {
            System.out.println("You just shift clicked!");
            ((InstantCraftInvoker) this).invokeClickSlot(syncId, 0, 0, SlotActionType.QUICK_MOVE, client.player);
        }
    }

//    @Inject(at = @At("HEAD"), method = "clickSlot")
//    private void clickSlot(int syncId, int slotId, int clickData, SlotActionType actionType, PlayerEntity player, CallbackInfoReturnable info) {
//        System.out.println(syncId);
//        System.out.println(slotId);
//        System.out.println(clickData);
//        System.out.println(actionType);
//        System.out.println(player);
//    }
}


