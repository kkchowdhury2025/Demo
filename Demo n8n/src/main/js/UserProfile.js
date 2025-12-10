import React from 'react';

// Existing component
function UserProfile({ user }) {
  // 'user' is expected to have 'id' and 'name' properties.
  return (
    <div className="profile">
      <h1>User Profile</h1>
      <p>ID: {user.id}</p>
      <p>Name: {user.name}</p>
    </div>
  );
}
export default UserProfile;
