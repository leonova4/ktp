package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState {
    /**
     * This is a reference to the map that the A* algorithm is navigating.
     **/
    private Map2D map;

    /**
     * Initialize a map of all open waypoints and their locations.
     **/
    private Map<Location, Waypoint> open_waypoints
            = new HashMap<Location, Waypoint>();

    /**
     * Initialize a map of all closed waypoints and their locations.
     **/
    private Map<Location, Waypoint> closed_waypoints
            = new HashMap<Location, Waypoint>();

    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map) {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /**
     * Returns the map that the A* pathfinder is navigating.
     **/
    public Map2D getMap() {
        return map;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint() {
        // Если нет открытых вершин, возвращаем null.
        if (numOpenWaypoints() == 0)
            return null;
        Set open_waypoint_keys = open_waypoints.keySet();
        Iterator i = open_waypoint_keys.iterator();
        Waypoint best = null;
        float best_cost = Float.MAX_VALUE;
        // Проверяет все вершины.
        while (i.hasNext()) {
            // Сохраняет текущую локацию.
            Location location = (Location) i.next();
            // Сохранет текущую вершину.
            Waypoint waypoint = open_waypoints.get(location);
            // Сохраняет текущую "стоимость" вершины.
            float waypoint_total_cost = waypoint.getTotalCost();

            // Если общая "стоимость" текущей вершины лучше (меньше)
            // тогда сохраненная "стоимость" сохраненной лучшей вершины заменяет
            // сохраненную вершину текущей вершины и сохраненную общую "стоимость"
            // текущей общей "стоимостью".
            if (waypoint_total_cost < best_cost) {
                best = open_waypoints.get(location);
                best_cost = waypoint_total_cost;
            }
        }
        // Возвращает вершину с минимальной общей "стоимостью".
        return best;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
    public boolean addOpenWaypoint(Waypoint newWP) {
        // Находит локацию новой вершины.
        Location location = newWP.getLocation();

        // Проверяет есть ли уже открытая вершина на месте новой вершины.
        if (open_waypoints.containsKey(location)) {
            // Если на этом месте уже есть открытая вершина,
            // проверяет меньше ли "предыдущая стоимость" новой вершины
            // "предыдущей стоимости" текущей.
            Waypoint current_waypoint = open_waypoints.get(location);
            if (newWP.getPreviousCost() < current_waypoint.getPreviousCost()) {
                // Если "предыдущая стоимость" новой вершины меньше
                // "предыдущей стоимости" текущей вершины, новая вершина
                // заменяет старую и возвращает true.
                open_waypoints.put(location, newWP);
                return true;
            }
            // Если "предыдущая стоимость" новой вершины не меньше "предыдущей стоимости"
            // текущей вершины, return false.
            return false;
        }
        // Если в наборе «открытых вершин» в настоящее время нет вершины для данного места,
        // то необходимо просто добавить новую вершину и return true.
        open_waypoints.put(location, newWP);
        return true;
    }


    /**
     * Returns the current number of open waypoints.
     **/
    public int numOpenWaypoints() {
        return open_waypoints.size();
    }


    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc) {
        Waypoint waypoint = open_waypoints.remove(loc);
        closed_waypoints.put(loc, waypoint);
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc) {
        return closed_waypoints.containsKey(loc);
    }
}