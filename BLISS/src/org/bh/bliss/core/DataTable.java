package org.bh.bliss.core;

import bht.tools.util.ArrayTable;
import java.util.Hashtable;

/**
 * DataTable, made for BLISS, is copyright Blue Husky Programming ©2013 CC 3.0 BY-SA<HR/>
 * 
 * @author Supuhstar of Blue Husky Programming
 * @version 1.0.0
 * @since 2013-07-30
 */
public interface DataTable<T>
{
	/**
	 * Adds the given items to the table as a new row
	 * @param items the items in the new row
	 * @return {@code this}
	 */
	public DataTable addRow(T... items);
	/**
	 * Removes the given row from the table immediately
	 * @param rowIndex the index of the row to remove
	 * @return {@code this}
	 */
	public DataTable removeRow(int rowIndex);
	/**
	 * Removes the given row from the table immediately
	 * @param rowIndex the key of the row to remove
	 * @return {@code this}
	 */
	public DataTable removeRow(Object rowKey);
	/**
	 * Refreshes the information in the given row to ensure it's current
	 * @param rowIndex the index of the row to refresh
	 * @return {@code this}
	 */
	public DataTable refreshRow(int rowIndex);
	/**
	 * Refreshes the information in the given row to ensure it's current
	 * @param rowIndex the key of the row to refresh
	 * @return {@code this}
	 */
	public DataTable refreshRow(Object rowKey);
	/**
	 * Inserts the given items as a new row after the one at the given index
	 * @param rowIndex the index of the previous row
	 * @param items the items in the new row
	 * @return {@code this}
	 */
	public DataTable insertRow(int rowIndex, T... items);
	/**
	 * Sets the key for the given row
	 * @param rowIndex the index of the row whose key is going to be set
	 * @param key the new key for the row
	 * @return {@code this}
	 */
	public DataTable setRowKey(int rowIndex, Object key);
	/**
	 * Sets the key for the given row
	 * @param oldRowKey the key of the row whose key is going to be set
	 * @param newRowKey the new key for the row
	 * @return {@code this}
	 */
	public DataTable setRowKey(Object oldRowKey, Object newRowKey);
	/**
	 * Returns the key for the given row
	 * @param rowIndex the index of the row whose key you wish to fetch
	 * @return {@code this}
	 */
	public Object getRowKey(int rowIndex);
	
	
	
	/**
	 * Adds the given items to the table as a new column
	 * @param items the items in the new column
	 * @return {@code this}
	 */
	public DataTable addColumn(T... items);
	/**
	 * Removes the given column from the table immediately
	 * @param colIndex the index of the column to remove
	 * @return {@code this}
	 */
	public DataTable removeColumn(int colIndex);
	/**
	 * Removes the given column from the table immediately
	 * @param rowIndex the key of the column to remove
	 * @return {@code this}
	 */
	public DataTable removeColumn(Object colKey);
	/**
	 * Refreshes the information for the given column to ensure it's current
	 * @param colIndex the index of the column to refresh
	 * @return {@code this}
	 */
	public DataTable refreshColumn(int colIndex);
	/**
	 * Refreshes the information for the given column to ensure it's current
	 * @param rowIndex the key of the row to refresh
	 * @return {@code this}
	 */
	public DataTable refreshColumn(Object colKey);
	/**
	 * Inserts the given items as a new column after the one at the given index
	 * @param colIndex the index of the previous column
	 * @param items the items in the new column
	 * @return {@code this}
	 */
	public DataTable insertColumn(int colIndex, T... items);
	/**
	 * Sets the key for the given column
	 * @param colIndex the index of the column whose key is going to be set
	 * @param key the new key for the column
	 * @return {@code this}
	 */
	public DataTable setColumnKey(int colIndex, Object key);
	/**
	 * Sets the key for the given column
	 * @param oldColKey the key of the column whose key is going to be set
	 * @param newColKey the new key for the column
	 * @return {@code this}
	 */
	public DataTable setColumnKey(Object oldColKey, Object newColKey);
	/**
	 * Returns the key for the given column
	 * @param columnIndex the index of the column whose key you wish to fetch
	 * @return {@code this}
	 */
	public Object getColumnKey(int columnIndex);
	
	
	
	/**
	 * Returns the contents of the given cell
	 * @param rowIndex the index of the row holding cell to read
	 * @param colIndex the index of the column holding the cell to read
	 * @return {@code this}
	 */
	public T getCell(int rowIndex, int colIndex);
	/**
	 * Returns the contents of the given cell
	 * @param rowKey the key of the row holding cell to read
	 * @param colKey the key of the column holding the cell to read
	 * @return {@code this}
	 */
	public T getCell(Object rowKey, Object colKey);
	/**
	 * Changes the value of the given cell
	 * @param rowIndex the index of the row holding the cell to change
	 * @param colIndex the index of the column holding the cell to change
	 * @param newValue the new value to put into the given cell
	 * @return the old value of the cell
	 */
	public T setCell(int rowIndex, int colIndex, T newValue);
	/**
	 * Changes the value of the given cell
	 * @param rowKey the key of the row holding the cell to change
	 * @param colKey the key of the column holding the cell to change
	 * @param newValue the new value to put into the given cell
	 * @return the old value of the cell
	 */
	public T setCell(Object rowKey, Object colKey, T newValue);
	/**
	 * Refreshes the information for the given cell to ensure it's current
	 * @param rowIndex the index of the row holding the cell to refresh
	 * @param colIndex the index of the column holding the cell to refresh
	 * @return {@code this}
	 */
	public DataTable refreshCell(int rowIndex, int colIndex);
	/**
	 * Refreshes the information for the given cell to ensure it's current
	 * @param rowKey the key of the row holding the cell to refresh
	 * @param colKey the key of the column holding the cell to refresh
	 * @return {@code this}
	 */
	public DataTable refreshCell(Object rowKey, Object colKey);
}
