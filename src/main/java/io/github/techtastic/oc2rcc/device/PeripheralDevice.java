package io.github.techtastic.oc2rcc.device;

import dan200.computercraft.api.peripheral.IPeripheral;
import io.github.techtastic.oc2rcc.OC2RCC;
import li.cil.oc2.api.bus.device.object.ObjectDevice;
import li.cil.oc2.api.bus.device.rpc.RPCDevice;
import li.cil.oc2.api.bus.device.rpc.RPCMethodGroup;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PeripheralDevice implements RPCDevice {
    private final ObjectDevice device;

    protected PeripheralDevice(IPeripheral peripheral) {
        this.device = new ObjectDevice(peripheral, peripheral.getType());

        OC2RCC.LOGGER.info("Peripheral Device created for {}", peripheral.getType());
        OC2RCC.LOGGER.info("Methods include: {}", this.device.getMethodGroups().stream().map(RPCMethodGroup::getName).toList());
    }

    public @NotNull List<String> getTypeNames() {
        return this.device.getTypeNames();
    }

    public @NotNull List<RPCMethodGroup> getMethodGroups() {
        return this.device.getMethodGroups();
    }
}
