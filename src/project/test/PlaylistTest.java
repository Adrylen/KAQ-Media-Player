/*
    Java Project
    Project
    Package : project.test

    Created by adrylen on 22/03/17.
*/

package project.test;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import project.path.PathFile;
import project.path.Playlist;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

@RunWith(JUnit4.class)
public class PlaylistTest extends TestCase {
	private Playlist playlist;

	@Before
	public void setUp() throws Exception {
		playlist = new Playlist();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test done");
		playlist = null;
		assertNull(playlist);
	}

	@Test
	public void testAdd() throws MalformedURLException {
		assertTrue(this.playlist.add(new PathFile("file:///")));
		assertFalse(this.playlist.add("Bonjour"));
		assertFalse(this.playlist.add(null));
	}

	@Test
	public void testAddI() throws MalformedURLException {
		assertTrue(this.playlist.add(new PathFile("file:///bin")));
		assertTrue(this.playlist.add(new PathFile("file:///usr")));
		this.playlist.add(1, new PathFile("file:///var"));
		assertEquals("/bin", this.playlist.get(0).getPath());
		assertEquals("/var", this.playlist.get(1).getPath());
		assertEquals("/usr", this.playlist.get(2).getPath());
	}

	@Test
	public void testAddAll() throws MalformedURLException {
		assertFalse(this.playlist.addAll(null));
		assertTrue(this.playlist.addAll(Arrays.asList(
			new PathFile("file:///bin"),
			new PathFile("file:///etc"),
			new PathFile("file:///lib"),
			new PathFile("file:///usr"),
			new PathFile("file:///var")
		)));
		assertNotNull(this.playlist.get(4));
		assertNull(this.playlist.get(5));
	}

	@Test
	public void testAddAllI() throws MalformedURLException {
		assertFalse(this.playlist.addAll(0, null));
		assertFalse(this.playlist.addAll(-1, Arrays.asList(new PathFile("file:///"))));
		assertFalse(this.playlist.addAll(12, Arrays.asList(new PathFile("file:///"))));
		assertTrue(this.playlist.addAll(0, Arrays.asList(
			new PathFile("file:///bin"),
			new PathFile("file:///etc"),
			new PathFile("file:///lib"),
			new PathFile("file:///usr")
		)));
		assertTrue(this.playlist.addAll(2, Arrays.asList(
			new PathFile("file:///boot"),
			new PathFile("file:///home"),
			new PathFile("file:///proc"),
			new PathFile("file:///root")
		)));
		assertEquals("/bin", this.playlist.get(0).getPath());
		assertEquals("/etc", this.playlist.get(1).getPath());
		assertEquals("/boot", this.playlist.get(2).getPath());
		assertEquals("/home", this.playlist.get(3).getPath());
		assertEquals("/proc", this.playlist.get(4).getPath());
		assertEquals("/root", this.playlist.get(5).getPath());
		assertEquals("/lib", this.playlist.get(6).getPath());
		assertEquals("/usr", this.playlist.get(7).getPath());
	}

	@Test
	public void testClear() throws MalformedURLException {
		assertTrue(this.playlist.add(new PathFile("file:///")));
		assertEquals("/", this.playlist.get(0).getPath());
		this.playlist.clear();
		assertNull(this.playlist.get(0));
	}

	@Test
	public void testContains() throws MalformedURLException {
		assertTrue(this.playlist.add(new PathFile("file:///")));
		assertTrue(this.playlist.contains(new PathFile("file:///")));
		assertFalse(this.playlist.contains(new PathFile("file:///home")));
	}

	@Test
	public void testContainsAll() throws MalformedURLException {
		assertTrue(this.playlist.addAll(0, Arrays.asList(
			new PathFile("file:///bin"),
			new PathFile("file:///etc"),
			new PathFile("file:///lib"),
			new PathFile("file:///usr")
		)));
		assertFalse(this.playlist.containsAll(null));
		assertFalse(this.playlist.containsAll(Arrays.asList(
			new PathFile("file:///bin"),
			new PathFile("file:///etc"),
			new PathFile("file:///lib"),
			new PathFile("file:///var")
		)));
		assertTrue(this.playlist.containsAll(Arrays.asList(
			new PathFile("file:///bin"),
			new PathFile("file:///etc"),
			new PathFile("file:///lib"),
			new PathFile("file:///usr")
		)));
	}

	@Test
	public void testCopy() throws MalformedURLException {
		assertTrue(this.playlist.addAll(Arrays.asList(
			new PathFile("file:///bin"),
			new PathFile("file:///etc"),
			new PathFile("file:///lib"),
			new PathFile("file:///usr")
		)));
		Playlist cloned = this.playlist.copy();
		assertNotSame(this.playlist, cloned);
	}

	@Test
	public void testGet() throws MalformedURLException {
		assertNull(this.playlist.get(0));
		assertTrue(this.playlist.add(new PathFile("file:///")));
		assertEquals("/", this.playlist.get(0).getPath());
	}

	@Test
	public void testGetPlaylist() throws MalformedURLException {
		assertEquals(10, this.playlist.getPlaylist().length);
	}

	@Test
	public void testIndexOf() throws MalformedURLException {
		assertTrue(this.playlist.add(new PathFile("file:///")));
		assertEquals(0, this.playlist.indexOf(new PathFile("file:///")));
		assertEquals(-1, this.playlist.indexOf(new PathFile("file:///home")));
	}

	@Test
	public void testIsEmpty() throws MalformedURLException {
		assertTrue(this.playlist.add(new PathFile("file:///")));
		assertFalse(this.playlist.isEmpty());
		this.playlist.clear();
		assertTrue(this.playlist.isEmpty());
	}

	@Test
	public void testIterator() throws MalformedURLException {
		int nb = 0;
		for(Iterator it = this.playlist.iterator(); it.hasNext(); it.next()) {
			++nb;
			if(nb == this.playlist.size()) {
				assertNull(it.next());
			}
		}
		assertEquals(this.playlist.size(), nb);
	}

	@Test
	public void testLastIndexOf() throws MalformedURLException {
		for(int i = 0; i < this.playlist.size(); ++i) {
			assertTrue(this.playlist.add(new PathFile("file:///")));
		}
		assertEquals(9, this.playlist.lastIndexOf(new PathFile("file:///")));
	}

	@Test
	public void testListIterator() throws MalformedURLException {
		for(int i = 0; i < this.playlist.size(); ++i) {
			this.playlist.set(i, new PathFile("file:///"));
		}
		for(ListIterator it = this.playlist.listIterator(); it.hasNext(); ) {
			assertEquals("/", ((PathFile) it.next()).getPath());
			assertEquals("/", ((PathFile) it.previous()).getPath());
			if(it.hasNext()) {
				assertEquals("/", ((PathFile) it.next()).getPath());
			}
		}
	}

	@Test
	public void testListIteratorI() throws MalformedURLException {
		int nb = 0;
		for(ListIterator it = this.playlist.listIterator(5); it.hasNext(); it.next()) {
			++nb;
		}
		assertEquals(4, nb);
	}

	@Test
	public void testRandomize() throws CloneNotSupportedException, MalformedURLException {
		assertTrue(this.playlist.addAll(Arrays.asList(
			new PathFile("file:///bin"),
			new PathFile("file:///etc"),
			new PathFile("file:///lib"),
			new PathFile("file:///usr")
		)));
		this.playlist.randomize().resize();
		for(int i = 0; i < this.playlist.size(); ++i) {
			System.out.print("| "+
				(this.playlist.get(i) != null ? this.playlist.get(i).getPath() : "none")
			+" |");
		}
		System.out.println();
	}

	@Test
	public void testRemove() throws MalformedURLException {
		assertTrue(this.playlist.add(new PathFile("file:///bin")));
		assertTrue(this.playlist.add(new PathFile("file:///home")));
		assertTrue(this.playlist.add(new PathFile("file:///lib")));
		assertTrue(this.playlist.add(new PathFile("file:///var")));
		assertTrue(this.playlist.add(new PathFile("file:///usr")));

		assertFalse(this.playlist.remove(new PathFile("file:///")));
		assertTrue(this.playlist.remove(new PathFile("file:///home")));
		assertEquals("/lib", this.playlist.get(1).getPath());
	}   // TODO

	@Test
	public void testRemoveI() throws MalformedURLException {
		assertTrue(this.playlist.add(new PathFile("file:///bin")));
		assertTrue(this.playlist.add(new PathFile("file:///home")));
		assertTrue(this.playlist.add(new PathFile("file:///lib")));
		assertTrue(this.playlist.add(new PathFile("file:///var")));
		assertTrue(this.playlist.add(new PathFile("file:///usr")));

		this.playlist.remove(-1).remove(5);
		assertEquals("/usr", this.playlist.remove(3).get(3).getPath());
	}   // TODO

	@Test
	public void testRemoveAll() throws MalformedURLException {
		assertTrue(this.playlist.add(new PathFile("file:///bin")));
		assertTrue(this.playlist.add(new PathFile("file:///etc")));
		assertTrue(this.playlist.add(new PathFile("file:///lib")));
		assertTrue(this.playlist.add(new PathFile("file:///var")));
		assertFalse(this.playlist.removeAll(null));
		assertFalse(this.playlist.removeAll(Arrays.asList(new PathFile("file:///"))));
		assertTrue(this.playlist.removeAll(Arrays.asList(
			new PathFile("file:///bin"),
			new PathFile("file:///lib")
		)));
		assertNull(this.playlist.get(2));
	}   // TODO

	@Test
	public void testResize() throws MalformedURLException {
		assertEquals(10, this.playlist.size());
		this.playlist.resize();
		assertEquals(0, this.playlist.size());
	}

	@Test
	public void testResizeI() throws MalformedURLException {
		assertEquals(10, this.playlist.size());
		this.playlist.resize(5);
		assertEquals(10, this.playlist.size());
		this.playlist.resize(12);
		assertEquals(12, this.playlist.size());
	}

	@Test
	public void testRestore() throws CloneNotSupportedException, MalformedURLException {
		assertTrue(this.playlist.addAll(Arrays.asList(
			new PathFile("file:///bin"),
			new PathFile("file:///etc"),
			new PathFile("file:///lib"),
			new PathFile("file:///usr")
		)));
		this.playlist.randomize().restore();
		assertEquals("/bin", this.playlist.get(0).getPath());
		assertEquals("/etc", this.playlist.get(1).getPath());
		assertEquals("/lib", this.playlist.get(2).getPath());
		assertEquals("/usr", this.playlist.get(3).getPath());
	}

	@Test
	public void testRetainsAll() throws MalformedURLException {
		assertTrue(this.playlist.add(new PathFile("file:///bin")));
		assertTrue(this.playlist.add(new PathFile("file:///etc")));
		assertTrue(this.playlist.add(new PathFile("file:///lib")));
		assertTrue(this.playlist.add(new PathFile("file:///var")));
		assertFalse(this.playlist.retainAll(null));
		assertTrue(this.playlist.retainAll(Arrays.asList(
			new PathFile("file:///bin"),
			new PathFile("file:///lib")
		)));
		assertEquals("/bin", this.playlist.get(0).getPath());
		assertEquals("/lib", this.playlist.get(1).getPath());
		assertNull(this.playlist.get(2));
	}   // TODO

	@Test
	public void testSet() throws MalformedURLException {
		assertTrue(this.playlist.add(new PathFile("file:///")));
		assertTrue(this.playlist.add(new PathFile("file:///home")));
		assertTrue(this.playlist.add(new PathFile("file:///bin")));
		this.playlist.set(1, new PathFile("file:///var")).set(5, new PathFile("file:///usr"));
		assertEquals("/var", this.playlist.get(1).getPath());
		assertEquals("/usr", this.playlist.get(3).getPath());
	}

	@Test
	public void testShuffle() throws CloneNotSupportedException, MalformedURLException {
		assertTrue(this.playlist.addAll(Arrays.asList(
			new PathFile("file:///bin"),
			new PathFile("file:///etc"),
			new PathFile("file:///lib"),
			new PathFile("file:///usr")
		)));
		Playlist shuffled = this.playlist.shuffle().resize();
		for(int i = 0; i < shuffled.size(); ++i) {
			System.out.print("| "+
				(shuffled.get(i) != null ? shuffled.get(i).getPath() : "none")
			+" |");
		}
		System.out.println();
	}

	@Test
	public void testSize() throws MalformedURLException {
		assertEquals(10, this.playlist.size());
	}

	@Test
	public void testSort() throws MalformedURLException {
		assertTrue(this.playlist.add(new PathFile("file:///bin")));
		assertTrue(this.playlist.add(new PathFile("file:///lib")));
		assertTrue(this.playlist.add(new PathFile("file:///home")));
		assertTrue(this.playlist.add(new PathFile("file:///")));
		this.playlist.sort();
		assertEquals("/", this.playlist.get(0).getPath());
		assertEquals("/bin", this.playlist.get(1).getPath());
		assertEquals("/home", this.playlist.get(2).getPath());
		assertEquals("/lib", this.playlist.get(3).getPath());
	}

	@Test
	public void testSubList() throws MalformedURLException {
		assertTrue(this.playlist.add(new PathFile("file:///bin")));
		assertTrue(this.playlist.add(new PathFile("file:///etc")));
		assertTrue(this.playlist.add(new PathFile("file:///home")));
		assertTrue(this.playlist.add(new PathFile("file:///lib")));
		assertTrue(this.playlist.add(new PathFile("file:///usr")));
		assertTrue(this.playlist.add(new PathFile("file:///var")));

		assertNull(this.playlist.subList(-1, 2));
		assertNull(this.playlist.subList(0, 13));
		assertNull(this.playlist.subList(2, 1));

		Playlist subList = this.playlist.subList(1, 4);
		assertEquals(3, subList.size());
		assertEquals("/etc", subList.get(0).getPath());
		assertEquals("/lib", subList.get(2).getPath());
	}   // TODO

	@Test
	public void testToArray() throws MalformedURLException {
		for(int i = 0; i < this.playlist.size(); ++i) {
			this.playlist.set(i, new PathFile("file:///"));
		}
		PathFile[] array = this.playlist.toArray();
		assertEquals(this.playlist.getPlaylist(), array);
	}

	@Test
	public void testToArrayO() throws MalformedURLException {
		assertTrue(this.playlist.add(new PathFile("file:///bin")));
		assertTrue(this.playlist.add(new PathFile("file:///etc")));
		assertTrue(this.playlist.add(new PathFile("file:///lib")));
		assertTrue(this.playlist.add(new PathFile("file:///home")));
		assertTrue(this.playlist.add(new PathFile("file:///usr")));
		assertTrue(this.playlist.add(new PathFile("file:///var")));

		PathFile[] array = this.playlist.toArray(new PathFile[] {
			new PathFile("file:///etc"),
			new PathFile("file:///usr")
		});

		assertEquals("/etc", array[0].getPath());
		assertEquals("/usr", array[1].getPath());
		assertNull(array[2]);
	}   // TODO
}
