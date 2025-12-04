package io.papermc.paper.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;

/**
 * Called when a block (e. g. a shelf) tries to connect to a neighbouring block.
 */
@NullMarked
public class BlockConnectEvent extends BlockEvent implements Cancellable {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final Block connectingToBlock;

    private boolean cancelled;

    @ApiStatus.Internal
    public BlockConnectEvent(final Block primaryBlock, final Block connectingToBlock) {
        super(primaryBlock);
        this.connectingToBlock = connectingToBlock;
    }

    /**
     * Gets the block that this block is connecting to.
     *
     * @return The other block.
     */
    public Block getConnectingToBlock() {
        return this.connectingToBlock;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(final boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
