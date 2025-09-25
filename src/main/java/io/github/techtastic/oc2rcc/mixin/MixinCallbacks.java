package io.github.techtastic.oc2rcc.mixin;

import dan200.computercraft.api.lua.LuaFunction;
import li.cil.oc2.api.bus.device.object.Callbacks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.Method;

@Mixin(Callbacks.class)
public class MixinCallbacks {
    @Inject(method = "lambda$getMethods$0", at = @At("RETURN"), cancellable = true)
    private static void oc2rcc$addLuaFunction(Method m, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(cir.getReturnValue() || m.isAnnotationPresent(LuaFunction.class));
    }
}
