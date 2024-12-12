function initMap() {
    // Initialize the map
    const map = new google.maps.Map(document.getElementById('map'), {
        center: { lat: 53.349805, lng: -6.26031 }, // Initial center point (Dublin)
        zoom: 12, // Initial zoom level
    });

    // List of locations with coordinates, names, and additional information
    const locations = [
        {
            name: "Grafton Street",
            lat: 53.342798,
            lng: -6.2597,
            address: "Grafton Street, Dublin, Ireland",
            phone: "+1 5589 55488 55",
        },
        {
            name: "Wellington Quay",
            lat: 53.3452,
            lng: -6.2662,
            address: "Wellington Quay, Dublin, Ireland",
            phone: "+1 5589 55488 56",
        },
        {
            name: "Sallynoggin",
            lat: 53.2774,
            lng: -6.1372,
            address: "Sallynoggin, Dublin, Ireland",
            phone: "+1 5589 55488 57",
        },
    ];

    // Create markers for each location on the map
    const markers = locations.map((location) => {
        return new google.maps.Marker({
            position: { lat: location.lat, lng: location.lng }, // Coordinates of the location
            map: map, // Attach the marker to the map
            title: location.name, // Tooltip title for the marker
        });
    });

    // Add click events to buttons in the location list
    const buttons = document.querySelectorAll(".services-list a"); // Select all location buttons
    const storeInfoContainer = document.getElementById("store-info"); // Store info container

    buttons.forEach((button, index) => {
        button.addEventListener("click", (event) => {
            event.preventDefault(); // Prevent default link behavior

            // Get the corresponding location
            const location = locations[index];

            // Update the map
            map.setCenter({ lat: location.lat, lng: location.lng }); // Center the map on the selected location
            map.setZoom(15); // Zoom in to the selected location

            // Update the store info container
            storeInfoContainer.innerHTML = `
                <h5>${location.name}</h5>
                <p><strong>Address:</strong> ${location.address}</p>
                <p><strong>Phone:</strong> ${location.phone}</p>
            `;
        });
    });
}

// Load the map when the page finishes loading
window.onload = initMap;
