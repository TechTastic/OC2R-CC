package io.github.techtastic.oc2rcc.device;

import dan200.computercraft.api.peripheral.IPeripheral;
import io.github.techtastic.oc2rcc.OC2RCC;
import li.cil.oc2.api.bus.device.Device;
import li.cil.oc2.api.bus.device.provider.BlockDeviceProvider;
import li.cil.oc2.api.bus.device.provider.BlockDeviceQuery;
import li.cil.oc2.api.util.Invalidatable;
import li.cil.oc2.api.util.Registries;
import li.cil.oc2.common.bus.device.provider.util.AbstractBlockDeviceProvider;
import dan200.computercraft.impl.Peripherals;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public class PeripheralDeviceProvider extends AbstractBlockDeviceProvider {
    @Override
    public @NotNull Invalidatable<Device> getDevice(@NotNull BlockDeviceQuery query) {
        LevelAccessor accessor = query.getLevel();
        if (accessor instanceof ServerLevel level) {
            IPeripheral peripheral =  Peripherals.getPeripheral(level, query.getQueryPosition(), query.getQuerySide(), () -> {});
            if (peripheral != null)
                return Invalidatable.of(new PeripheralDevice(peripheral));
        }

        return Invalidatable.empty();
    }

    public static void register(IEventBus bus) {
        DeferredRegister<BlockDeviceProvider> providers = DeferredRegister.create(Registries.BLOCK_DEVICE_PROVIDER, OC2RCC.MODID);
        providers.register("peripheral", PeripheralDeviceProvider::new);
        providers.register(bus);
    }
}
