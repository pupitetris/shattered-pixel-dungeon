/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2022 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.effects;

import com.shatteredpixel.shatteredpixeldungeon.tiles.DungeonTilemap;
import com.shatteredpixel.shatteredpixeldungeon.ui.Icons;
import com.watabou.noosa.Game;
import com.watabou.noosa.Image;

public class TargetedCell extends Image {

	private float alpha;
	private boolean fixed;

	public TargetedCell( int pos, int color ) {
		super(Icons.get(Icons.TARGET));
		hardlight(color);
		origin.set( width/2f );
		setPos(pos);
		alpha = 1f;
		fixed = false;
	}

	public void setPos( int pos ) {
		if (pos >= 0) {
			point( DungeonTilemap.tileToWorld( pos ) );
		}
	}

	public void setFixed( boolean isFixed ) {
		fixed = isFixed;
	}

	@Override
	public void update() {
		if (!fixed) {
			if ((alpha -= Game.elapsed/2f) > 0) {
				alpha( alpha );
				scale.set( alpha );
			} else {
				killAndErase();
			}
		}
	}
}
