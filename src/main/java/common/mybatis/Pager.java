package common.mybatis;

import java.util.List;

/**
 * 分页模型
 * @author YJM
 *
 * @param <T>
 */
public class Pager<T> {
	private Long count;
	private Integer pageIndex;
	private Integer pageSize;
	private List<T> data;
	
	/**
	 * 生成分页
	 * @param count 总条数
	 * @param pageIndex 当前页码
	 * @param pageSize 分页大小
	 * @param data 分页数据
	 */
	public Pager(Long count, Integer pageIndex, Integer pageSize, List<T> data){
		this.count = count;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.data = data;
	}
	
	/**
	 * 总条数
	 */
	public Long getCount() {
		return count;
	}
	/**
	 * 当前页码
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}
	/**
	 * 分页大小
	 */
	public Integer getPageSize() {
		return pageSize;
	}
	/**
	 * 当前页数据
	 */
	public List<T> getData() {
		return data;
	}
	/**
	 * 总页数
	 */
	public Integer getPageCount(){
		return (int)(count / pageSize + (count % pageSize > 0 ? 1 : 0));
	}
}
