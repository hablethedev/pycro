package hazel.pycro.mixin;

import com.mojang.authlib.GameProfile;
import hazel.pycro.PycroClient;
import net.minecraft.client.network.message.MessageHandler;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MessageHandler.class)
public class MessageHandlerMixin {

    @Inject(at = @At("RETURN"), method = "onChatMessage")
    public void onChatMessage(SignedMessage signedMessage, GameProfile sender, MessageType.Parameters params, CallbackInfo ci) {
        Text message = params.applyChatDecoration(signedMessage.getContent());
        PycroClient.onMessage(message);
    }

    @Inject(at = @At("RETURN"), method = "onGameMessage")
    public void onGameMessage(Text message, boolean overlay, CallbackInfo ci) {
        if (!overlay) {
            PycroClient.onMessage(message);
        }
    }
}
