package dev.jaxarthur.instantcraft.mixin;

import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ClientPlayerInteractionManager.class)
public interface InstantCraftInvoker {
    @Invoker("clickSlot")
    ItemStack invokeClickSlot(int syncId, int slotId, int clickData, SlotActionType actionType, PlayerEntity player);
}
