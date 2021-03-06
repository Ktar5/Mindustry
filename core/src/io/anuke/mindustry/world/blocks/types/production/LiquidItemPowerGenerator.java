package io.anuke.mindustry.world.blocks.types.production;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import io.anuke.mindustry.Vars;
import io.anuke.mindustry.entities.TileEntity;
import io.anuke.mindustry.resource.Item;
import io.anuke.mindustry.world.Tile;
import io.anuke.ucore.core.Draw;

public class LiquidItemPowerGenerator extends LiquidPowerGenerator{
	public Item generateItem;
	public int itemInput = 5;
	public int itemCapacity = 30;

	public LiquidItemPowerGenerator(String name) {
		super(name);
	}
	
	@Override
	public void drawSelect(Tile tile){
		super.drawSelect(tile);
		
		TileEntity entity = tile.entity();
		
		Vector2 offset = getPlaceOffset();
		
		Vars.renderer.drawBar(Color.GREEN, tile.worldx() + offset.x, tile.worldy() + 6 +
				offset.y + height*Vars.tilesize/2f, (float)entity.getItem(generateItem) / itemCapacity);
		Draw.reset();
	}
	
	//TODO implement?
	/*
	@Override
	public void update(Tile tile){
		LiquidPowerEntity entity = tile.entity();

		//TODO don't generate when full of energy
		if(entity.liquidAmount >= inputLiquid && entity.hasItem(generateItem, itemInput) 
				&& entity.power + generatePower < powerCapacity 
				&& Timers.get(tile, "consume", generateTime)){
			entity.liquidAmount -= inputLiquid;
			entity.power += generatePower;
			
			Vector2 offset = getPlaceOffset();
			Effects.effect(generateEffect, tile.worldx() + offset.x, tile.worldy() + offset.y);
		}
		
		distributeLaserPower(tile);
		
	}*/
	
	@Override
	public boolean acceptItem(Item item, Tile tile, Tile source){
		return item == generateItem && tile.entity.getItem(generateItem) < itemCapacity;
	}

}
