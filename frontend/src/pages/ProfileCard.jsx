import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const ProfileCard = () => {
  const [activeTab, setActiveTab] = useState("one");

  return (
    <div className="profile-card-container col-sm-6 col-md-4 col-lg-3 mt-4">
      <div className="profile-card card">
        {/* Ảnh Banner */}
        <img className="profile-banner card-img-top" src="https://picsum.photos/200/150/?random" alt="Banner" />

        {/* Thông tin người dùng */}
        <div className="profile-card-body card-block text-center">
          <figure className="profile-avatar-wrapper">
            <img src="https://picsum.photos/200/150/?random" className="profile-avatar rounded-circle" alt="Avatar" />
          </figure>
          <h4 className="profile-name card-title mt-3">NameName</h4>
          <div className="profile-status meta">
            <span className="badge badge-primary">Friends</span>
          </div>
          <p className="profile-description card-text">hihi</p>
        </div>

        {/* Tabs điều hướng */}
        <div className="profile-tabs card-footer">
          <ul className="nav nav-tabs card-header-tabs">
            {["one", "two", "three"].map((tab) => (
              <li className="nav-item" key={tab}>
                <button
                  className={`nav-link ${activeTab === tab ? "active" : ""}`}
                  onClick={() => setActiveTab(tab)}
                >
                  {tab.charAt(0).toUpperCase() + tab.slice(1)}
                </button>
              </li>
            ))}
          </ul>
        </div>

        {/* Nội dung tab */}
        <div className="profile-tab-content tab-content p-3">
          {activeTab === "one" && (
            <div className="profile-tab-pane">
              <h5 className="profile-tab-title card-title">Tab Card One</h5>
              <p className="profile-tab-text card-text">Some quick example text to build on the card title.</p>
              <a href="#" className="btn btn-primary">Go somewhere</a>
            </div>
          )}
          {activeTab === "two" && (
            <div className="profile-tab-pane">
              <h5 className="profile-tab-title card-title">Tab Card Two</h5>
              <p className="profile-tab-text card-text">Some quick example text to build on the card title.</p>
              <a href="#" className="btn btn-primary">Go somewhere</a>
            </div>
          )}
          {activeTab === "three" && (
            <div className="profile-tab-pane">
              <h5 className="profile-tab-title card-title">Tab Card Three</h5>
              <p className="profile-tab-text card-text">Some quick example text to build on the card title.</p>
              <a href="#" className="btn btn-primary">Go somewhere</a>
            </div>
          )}
        </div>
      </div>
    </div>
     
  );
  
};

export default ProfileCard;
