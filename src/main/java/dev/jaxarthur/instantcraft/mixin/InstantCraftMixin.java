package dev.jaxarthur.instantcraft.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.CraftingScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
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
        if (craftAll && (client.currentScreen instanceof CraftingScreen || client.currentScreen instanceof InventoryScreen)) {
            System.out.println(client.currentScreen);
            ((InstantCraftInvoker) this).invokeClickSlot(syncId, 0, 0, SlotActionType.QUICK_MOVE, client.player);
        }
    }
}


