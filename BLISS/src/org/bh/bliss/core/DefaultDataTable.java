package org.bh.bliss.core;

import org.bh.bliss.core.DataTable;
import bht.tools.util.ArrayPP;
import bht.tools.util.ArrayTable;
import java.util.logging.Logger;

/**
 * DefaultDataTable, made for BLISS, is copyright Blue Husky Programming ©2013 CC 3.0 BY-SA<HR/>
 * 
 * @author Supuhstar of Blue Husky Programming
 * @version 1.0.0
 * @since 2013-07-31
 */
public class DefaultDataTable implements DataTable<Object>
{
	private ArrayTable<Object> core = new ArrayTable<>();
	@Override
	public DataTable addRow(Object... items)
	{
		core.addRow(items);
		return this;
	}

	@Override
	public DataTable removeRow(int rowIndex)
	{
		core.removeRow(rowIndex);
		return this;
	}

	@Override
	public DataTable removeRow(Object rowKey)
	{
		core.removeRow(rowKey);
		return this;
	}

	@Override
	public DataTable refreshRow(int rowIndex)
	{
		for (int i=0, l=core.getRow(rowIndex).length(); i < l; i++)
			refreshCell(rowIndex, i);
		return this;
	}

	@Override
	public DataTable refreshRow(Object rowKey)
	{
		for (int i=0, l=core.getRow(rowKey).length(); i < l; i++)
			refreshCell(rowKey, i);
		return this;
	}

	@Override
	public DataTable insertRow(int rowIndex, Object... items)
	{
		core.insertRow(new ArrayPP<>(items), rowIndex);
		return this;
	}

	@Override
	public DataTable setRowKey(int rowIndex, Object key)
	{
		core.setRowKey(rowIndex, key);
		return this;
	}

	@Override
	public DataTable setRowKey(Object oldRowKey, Object newRowKey)
	{
		core.setRowKey(core.getRowIndexForKey(oldRowKey), newRowKey);
		return this;
	}

	@Override
	public Object getRowKey(int rowIndex)
	{
		return core.getRowKey(rowIndex);
	}

	@Override
	public DataTable addColumn(Object... items)
	{
		core.addCol(items);
		return this;
	}

	@Override
	public DataTable removeColumn(int colIndex)
	{
		core.removeCol(colIndex);
		return this;
	}

	@Override
	public DataTable removeColumn(Object colKey)
	{
		core.removeCol(colKey);
		return this;
	}

	@Override
	public DataTable refreshColumn(int colIndex)
	{
		for (int i=0, l=core.getCol(colIndex).length(); i < l; i++)
			refreshCell(colIndex, i);
		return this;
	}

	@Override
	public DataTable refreshColumn(Object colKey)
	{
		for (int i=0, l=core.getCol(colKey).length(); i < l; i++)
			refreshCell(colKey, i);
		return this;
	}

	@Override
	public DataTable insertColumn(int colIndex, Object... items)
	{
		core.insertColumn(new ArrayPP<>(items), colIndex);
		return this;
	}

	@Override
	public DataTable setColumnKey(int colIndex, Object key)
	{
		core.setColumnKey(colIndex, key);
		return this;
	}

	@Override
	public DataTable setColumnKey(Object oldColKey, Object newColKey)
	{
		core.setColumnKey(core.getColIndexForKey(oldColKey), newColKey);
		return this;
	}

	@Override
	public Object getColumnKey(int columnIndex)
	{
		return core.getColumnKey(columnIndex);
	}

	@Override
	public Object getCell(int rowIndex, int colIndex)
	{
		return core.getCell(colIndex, rowIndex);
	}

	@Override
	public Object getCell(Object rowKey, Object colKey)
	{
		return core.getCell(colKey, rowKey);
	}

	@Override
	public Object setCell(int rowIndex, int colIndex, Object newValue)
	{
		Object ret = core.getCell(colIndex, rowIndex);
		core.setCell(rowIndex, colIndex, newValue);
		return ret;
	}

	@Override
	public Object setCell(Object rowKey, Object colKey, Object newValue)
	{
		Object ret = core.getCell(colKey, rowKey);
		core.setCell(rowKey, colKey, newValue);
		return ret;
	}

	@Override
	public DataTable refreshCell(int rowIndex, int colIndex)
	{
		Logger.getLogger(DefaultDataTable.class.getCanonicalName()).warning("Refresh does nothing");
		return this;
	}

	@Override
	public DataTable refreshCell(Object rowKey, Object colKey)
	{
		return refreshCell(core.getRowIndexForKey(rowKey), core.getColIndexForKey(colKey));
	}
}
