/*
    Java Project
    Project
    Package : project.path

    Created by adrylen on 22/03/17.
*/

package project.media.files;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Playlist implements List {
	private static final int DEFAULT_LENGTH = 10;

	private PathFile[] playlist;
	private PathFile[] originalList = null;
	private boolean randomized = false;

	public Playlist() {
		this(-1);
	}

	private Playlist(int size) {
		this.playlist = new PathFile[(size < 0) ? DEFAULT_LENGTH : size];
	}

	//  Tested
	public Playlist copy() {
		Playlist cloned = new Playlist(this.playlist.length);
		for(int i = 0; i < this.playlist.length; ++i) {
			cloned.set(i, this.playlist[i]);
		}
		return cloned;
	}

	//  Tested
	public PathFile[] getPlaylist() {
		return this.playlist;
	}

	//  Tested
	public Playlist shuffle() throws CloneNotSupportedException {
		Playlist shuffled = copy();
		for(int i = 0; i < this.playlist.length; ++i) {
			int j = new Random().nextInt(shuffled.size());
			PathFile tmp = shuffled.get(i);
			shuffled.getPlaylist()[i] = shuffled.get(j);
			shuffled.getPlaylist()[j] = tmp;
		}
		return shuffled;
	}

	//  Tested
	public void sort() {
		for(int i = 0; i < this.playlist.length-1; ++i) {
			if(this.playlist[i] != null) {
				for(int j = i+1; j < this.playlist.length; ++j) {
					if(this.playlist[j] != null) {
						if(this.playlist[i].getPath().compareTo(this.playlist[j].getPath()) > 0) {
							PathFile tmp = this.playlist[i];
							this.playlist[i] = this.playlist[j];
							this.playlist[j] = tmp;
						}
					}
				}
			}
		}
	}

	//  Tested
	public Playlist randomize() throws CloneNotSupportedException {
		this.originalList = this.playlist;
		this.playlist = shuffle().getPlaylist();
		this.randomized = true;
		return this;
	}

	//  Tested
	public Playlist resize() {
		int size = 0;
		for(int i = 0; i < this.playlist.length; ++i) {
			if(this.playlist[i] != null) {
				int j = i-1; size++;
				if(j >= 0) {
					while(this.playlist[j] == null) {
						this.playlist[j] = this.playlist[j+1];
						this.playlist[j+1] = null;
						if(--j < 0) {
							break;
						}
					}
				}
			}
		}
		PathFile[] newPlaylist = new PathFile[size];
		System.arraycopy(newPlaylist, 0, this.playlist, 0, size);
		this.playlist = newPlaylist;
		return this;
	}

	//  Tested
	public void resize(int size) {
		if(size > this.playlist.length) {
			PathFile[] newPlaylist = new PathFile[size];
			System.arraycopy(newPlaylist, 0, this.playlist, 0, this.playlist.length);
			playlist = newPlaylist;
		}
	}

	//  Tested
	public void restore() {
		if(randomized) {
			this.playlist = this.originalList;
			this.originalList = null;
			this.randomized = false;
		}
	}

	@Override   //  Tested
	public boolean add(Object o) {
		if(o instanceof PathFile) {
			for(int i = 0; i < this.playlist.length; ++i) {
				if(this.playlist[i] == null) {
					this.playlist[i] = (PathFile) o;
					return true;
				}
			}
			resize(this.playlist.length+1);
			this.playlist[this.playlist.length+1] = (PathFile) o;
			return true;
		}
		return false;
	}

	@Override   //  Tested
	public void add(int rank, Object o) {
		if((rank >= 0 || rank <= this.playlist.length) && o instanceof PathFile) {
			if(this.playlist[rank] == null) {
				add(o);
			} else if(this.playlist[this.playlist.length-1] == null) {
				PathFile tmp, newElement = (PathFile) o;
				for(int i = rank; i < this.playlist.length; ++i) {
					if(this.playlist[i] == null) {
						this.playlist[i] = newElement;
						break;
					}
					tmp = this.playlist[i];
					this.playlist[i] = newElement;
					newElement = tmp;
				}
			} else {
				resize(this.playlist.length+1);
				add(o);
			}
		}
	}

	@Override   //  Tested
	public boolean addAll(Collection collection) {
		if(collection == null) {
			return false;
		}
		for(Object o : collection) {
			if(!add(o)) {
				return false;
			}
		}
		return true;
	}

	@Override   //  Tested
	public boolean addAll(int i, Collection collection)	{
		if(collection == null || i < 0 || i > this.playlist.length) {
			return false;
		}
		for(Object o : collection) {
			if(o instanceof PathFile) {
				add(i++, o);
			}
		}
		return true;
	}

	@Override   //  Tested
	public void clear() {
		for(int i = 0; i < this.playlist.length; ++i) {
			if(this.playlist[i] != null) {
				this.playlist[i] = null;
			}
		}
	}

	@Override   //  Tested
	public boolean contains(Object o) {
		if(o instanceof PathFile) {
			for(PathFile file : this.playlist) {
				if(file == null) {
					continue;
				}
				if(file.getPath().equals(((PathFile) o).getPath())) {
					return true;
				}
			}
		}
		return false;
	}

	@Override   //  Tested
	public boolean containsAll(Collection collection) {
		if(collection == null) {
			return false;
		}
		for(Object o : collection) {
			if(!contains(o)) {
				return false;
			}
		}
		return true;
	}

	@Override   //  Tested
	public PathFile get(int i) {
		return i >= 0 && i < this.playlist.length ? this.playlist[i] : null;
	}

	@Override   //  Tested
	public int indexOf(Object o) {
		if(contains(o)) {
			int i = 0;
			for(PathFile file : this.playlist) {
				if(file.getPath().equals(((PathFile) o).getPath())) {
					return i;
				}
				++i;
			}
		}
		return -1;
	}

	@Override   //  Tested
	public boolean isEmpty() {
		for(PathFile file : this.playlist) {
			if(file != null) {
				return false;
			}
		}
		return true;
	}

	@Override   //  Tested
	public Iterator iterator() {
		return new Iterator() {
			private int id = 0;
			@Override
			public boolean hasNext() {
				return id >= 0 && id < playlist.length;
			}
			@Override
			public Object next() {
				return id < playlist.length ? playlist[id++] : null;
			}
		};
	}

	@Override   //  Tested
	public int lastIndexOf(Object o) {
		if(contains(o)) {
			for(int i = this.playlist.length-1; i >= 0; --i) {
				if(this.playlist[i].getPath().equals(((PathFile)o).getPath())) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override   //  Tested
	public ListIterator listIterator() {
		return listIterator(0);
	}

	@Override   //  Tested
	public ListIterator listIterator(int i) {
		return new ListIterator() {
			private int id = i;
			@Override
			public boolean hasNext() {
				return id < playlist.length-1;
			}
			@Override
			public PathFile next() {
				return id >= 0 && id < playlist.length ? playlist[id++] : null;
			}
			@Override
			public boolean hasPrevious() {
				return id > 0;
			}
			@Override
			public PathFile previous() {
				return id >= 0 && id < playlist.length ? playlist[id--] : null;
			}
			@Override
			public int nextIndex() {
				return id < playlist.length-1 ? id+1 : -1;
			}
			@Override
			public int previousIndex() {
				return id > 0 ? id-1 : -1;
			}
			@Override
			public void remove() {
				Playlist.this.remove(id);
			}
			@Override
			public void set(Object o) {
				Playlist.this.set(id, o);
			}
			@Override
			public void add(Object o) {
				Playlist.this.add(id, o);
			}
		};
	}

	@Override   //  Tested
	public boolean remove(Object o) {
		if(contains(o)) {
			System.arraycopy(this.playlist, indexOf(o), this.playlist, indexOf(o)+1, this.playlist.length-1);
			this.playlist[this.playlist.length-1] = null;
			return true;
		}
		return false;
	}

	@Override   //  Tested
	public Playlist remove(int i) {
		if(i >= 0 && i < this.playlist.length) {
			remove(this.playlist[i]);
		}
		return this;
	}

	@Override   //  Tested
	public boolean removeAll(Collection collection) {
		if(collection == null) {
			return false;
		}
		boolean removed = false;
		for(Object o : collection) {
			if(contains(o)) {
				if(!remove(o)) {
					return false;
				} else {
					removed = true;
				}
			}
		}
		return removed;
	}

	@Override   //  Tested
	public boolean retainAll(Collection collection) {
		if(collection == null) {
			return false;
		}
		for(int i = 0; i < this.playlist.length; ++i) {
			if(this.playlist[i] == null) {
				break;
			}
			boolean retained = false;
			for(Object o : collection) {
				if(((PathFile) o).getPath().equals(this.playlist[i].getPath())) {
					retained = true;
					break;
				}
			}
			if(!retained) {
				if(!remove(this.playlist[i--])) {
					return false;
				}
			}
		}
		return true;
	}

	@Override   //  Tested
	public Playlist set(int i, Object o) {
		if(i >= 0 && i < this.playlist.length) {
			if(this.playlist[i] == null) {
				add(o);
			} else {
				this.playlist[i] = (PathFile) o;
			}
		}
		return this;
	}

	@Override   //  Tested
	public int size() {
		return this.playlist.length;
	}

	@Override   //  Tested
	public Playlist subList(int i, int i1) {
		if(i >= 0 && i1 <= this.playlist.length && i < i1) {
			Playlist subList = new Playlist(i1-i);
			for(int j = 0; j < subList.size(); ++j) {
				subList.set(j, this.playlist[i+j]);
			}
			return subList;
		}
		return this;
	}

	@Override   //  Tested
	public PathFile[] toArray() {
		return this.playlist;
	}

	@Override   //  Tested
	public PathFile[] toArray(Object[] objects) {
		PathFile[] resultList, tmpList = this.playlist;
		for(int i = 0; i < this.playlist.length; ++i) {
			if(this.playlist[i] != null) {
				boolean in = false;
				for(Object o : objects) {
					if(this.playlist[i].getPath().equals(((PathFile) o).getPath())) {
						in = true;
						break;
					}
				}
				if(!in) {
					remove(this.playlist[i--]);
				}
			}
		}
		resultList = this.playlist;
		this.playlist = tmpList;
		return resultList;
	}
}
